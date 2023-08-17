package com.example.fleetiocore.model

import androidx.annotation.Keep

@Keep
sealed class FleetioError {
    /**
     * The error message.
     *
     * @since 1.0
     */
    abstract val message: String?


    /**
     * Models a generic error.
     *
     * @property message The error message.
     * @property throwable The error.
     * @constructor Creates a GenericError that contains an error message.
     *
     * @since 1.0
     */
    @Keep
    data class GenericError(override val message: String?, val throwable: Throwable? = null) :
        FleetioError()

    /**
     * Models an error indicating there is no internet.
     *
     * @property message The error message.
     * @constructor Creates a NoInternet that contains an error message.
     *
     * @since 1.0
     */
    @Keep
    data class NoInternet(override val message: String? = "Internet not available") : FleetioError()
}
