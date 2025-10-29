package com.bouzajesus.horoscapp.data.network.interceptors

import jakarta.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header("Authorization", tokenManager.getToken())
            .build()

        return chain.proceed(request)
    }
}

//Clase TokenManager de ejemplo
class TokenManager @Inject constructor(){
    fun getToken(): String = "TOKEN_DE_EJEMPLO"
}