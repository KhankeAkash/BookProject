package com.example.bookproject.login

import android.R
import android.R.attr.password
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookproject.Retrofit.AuthRepositary
import com.example.bookproject.Retrofit.LoginRequest
import com.example.bookproject.Retrofit.LoginResponse
import com.example.bookproject.Retrofit.preLoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthRepositary
) : ViewModel() {

    val loginResponse = MutableLiveData<LoginResponse?>()
    val preLoginResponse = MutableLiveData<preLoginResponse?>()
    val errorMessage = MutableLiveData<String>()

    fun login(authHeader: String? ,username: String, password: String) {

        viewModelScope.launch {

            try {

                val response = repository.login(
                    authHeader,
                    username, password
                )

                if (response.isSuccessful) {
                    loginResponse.value = response.body()
                } else {
                    errorMessage.value = response.message()
                }

            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }

    fun preLogin(username: String, password: String) {

        viewModelScope.launch {

            try {

                val response = repository.prelogin(
                    username ,
                    password
                )

                if (response.isSuccessful) {
                    preLoginResponse.value = response.body()
                } else {
                    errorMessage.value = response.message()
                }

            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }
}