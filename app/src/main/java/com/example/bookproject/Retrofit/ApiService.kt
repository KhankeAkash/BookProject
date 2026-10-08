package com.example.bookproject.Retrofit


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("users/signin")
    suspend fun login(
        @Header("Authorization") authHeader: String?,

        @Body request: LoginRequest
    ): Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("api/auth/login")
    suspend fun prelogin(

        @Body request: preloginRequestModel
    ): Response<preLoginResponse>

    @Headers("Content-Type: application/json")
    @POST("MasterController/callMaster")
    suspend fun syncRequest(
        @Header("Authorization") authHeader: String?,

        @Body request: SyncRequestModel
    ): Response<MasterDataResponse>
}