package com.example.fleetiocore.util

import com.example.fleetiocore.model.FleetioError


inline fun <reified X> EitherResult<*, *>.getAs() = when (this) {
    is EitherResult.Success -> value as? X
    is EitherResult.Failure -> error as? X
}

fun <V : Any> EitherResult<V, *>.success(f: (V) -> Unit) = fold(f, {})

fun <E : FleetioError> EitherResult<*, E>.failure(f: (E) -> Unit) = fold({}, f)

infix fun <V : Any, E : FleetioError> EitherResult<V, E>.or(fallback: V) = when (this) {
    is EitherResult.Success -> this
    else -> EitherResult.Success(fallback)
}

infix fun <V : Any, E : FleetioError> EitherResult<V, E>.getOrElse(fallback: V) = when (this) {
    is EitherResult.Success -> value
    else -> fallback
}


@Suppress("UNCHECKED_CAST")
sealed class EitherResult<out V : Any, out E : FleetioError> {

    open operator fun component1(): V? = null
    open operator fun component2(): E? = null

    inline fun <X> fold(success: (V) -> X, failure: (E) -> X): X = when (this) {
        is Success -> success(this.value)
        is Failure -> failure(this.error)
    }

    abstract fun get(): V

    class Success<out V : Any>(val value: V) : EitherResult<V, Nothing>() {
        override fun component1(): V? = value

        override fun get(): V = value

        override fun toString() = "[Success: $value]"

        override fun hashCode(): Int = value.hashCode()

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            return other is Success<*> && value == other.value
        }
    }

    class Failure<out E : FleetioError>(val error: E) : EitherResult<Nothing, E>() {

        override fun get() = throw IllegalAccessException(error.message)

        override fun component2(): E? = error

        fun getFleetioError(): E = error

        override fun toString() = "[Failure: $error]"

        override fun hashCode(): Int = error.hashCode()

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            return other is Failure<*> && error == other.error
        }
    }

    companion object {
        // Factory methods
        fun <E : FleetioError> error(ex: E) =
            Failure(ex)

        fun <V : Any> success(v: V) = Success(v)

        fun <V : Any> of(
            value: V?,
            fail: (() -> FleetioError) = {
                FleetioError.GenericError(
                    "",
                    Exception()
                )
            }
        ): EitherResult<V, FleetioError> =
            value?.let { success(it) } ?: error(
                fail()
            )

        fun <V : Any, E : FleetioError> of(f: () -> V): EitherResult<V, E> = try {
            success(f())
        } catch (ex: Exception) {
            error(
                FleetioError.GenericError(
                    "",
                    ex
                ) as E
            )
        }
    }
}
