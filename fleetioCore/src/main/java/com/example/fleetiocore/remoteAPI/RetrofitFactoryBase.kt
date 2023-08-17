package com.example.fleetiocore.remoteAPI

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal open class RetrofitFactoryBase(private val okHttpClientCore: OkHttpClient) {

    companion object {
        private const val TIME_OUT: Long = 15
        private const val CALL_TIME_OUT: Long = 10
    }

    /**
     * Sets a retrofit instance with the same type as the api that is being set,
     * the base url needs to be http compliant.
     *
     * @param base Base url to set a retrofit instance with
     *
     * @param api Retrofit interface to be setup
     *
     * @param interceptor to be used to catch all network transactions.
     */

    fun <T> provideRetrofit(base: String, api: Class<T>, interceptor: Interceptor? = null): T {

        val retrofit = Retrofit.Builder()
            .baseUrl(base)
            .client(getOrGenerateOkHttpClient(interceptor, false))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(api)
    }


    /**
     * Sets a retrofit instance with the same type as the api that is being set,
     * the base url needs to be http compliant.
     *
     * @param base Base url to set a retrofit instance with
     *
     * @param api Retrofit interface to be setup
     *
     * @param interceptor to be used to catch all network transactions.
     *
     * @param isConnectionLimited when true will limit the connection time else will use our internal default values.
     */
    fun <T> provideRetrofit(
        base: String,
        api: Class<T>,
        interceptor: Interceptor? = null,
        isConnectionLimited: Boolean = false
    ): T {

        val retrofit = Retrofit.Builder()
            .baseUrl(base)
            .client(getOrGenerateOkHttpClient(interceptor, isConnectionLimited))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(api)


    }

    private fun getOrGenerateOkHttpClient(
        interceptor: Interceptor? = null,
        isConnectionLimited: Boolean = false
    ): OkHttpClient {

        return okHttpClientCore.newBuilder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .cache(null)
            .retryOnConnectionFailure(false)
            .build()
    }
}