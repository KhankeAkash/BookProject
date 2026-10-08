package com.example.bookproject.Retrofit

import retrofit2.Response


class AuthRepositary {

    suspend fun login(
        authHeader: String?,
        username: String,
        password: String,
    ): Response<LoginResponse> {

        val authHeader = "Bearer $authHeader"
        return retrofit.apiService.login(
            authHeader ,LoginRequest(
                username,
                password
            )

        )
    }

    suspend fun prelogin(
        username: String,
        password: String,
    ) : Response<preLoginResponse>
    {
        return retrofit.apiService.prelogin(
            preloginRequestModel(username,password)
        )
    }


}