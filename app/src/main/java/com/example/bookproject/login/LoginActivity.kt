package com.example.bookproject.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.bookproject.Retrofit.AuthRepositary
import com.example.bookproject.RoomDB.AppDatabase
import com.example.bookproject.RoomDB.UserEntity
import com.example.bookproject.common.custom_views.Constant
import com.example.bookproject.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var database : AppDatabase
    var bearerToken : String? = null
    private val viewModel: LoginViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return LoginViewModel(AuthRepositary()) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        database = AppDatabase.getInstance(this)
        setContentView(binding.root)

        binding.loginBtn.isEnabled = false

        viewModel.preLogin("absb2user_uat","UatApiPass@2026!")
        observepreLogin()
        observeData()

        viewModel.errorMessage.observe(this) { error ->
            Log.e("PRELOGIN_ERROR", "error: $error")
        }

        binding.loginBtn.setOnClickListener {

            val intent = Intent(this, MyForegroundService::class.java)

            ContextCompat.startForegroundService(
                this,
                intent
            )
            viewModel.login(
                bearerToken,
                binding.usernameEdt.text.toString(),
                binding.passEdt.text.toString()
            )
        }
    }

    fun observeData() {
        viewModel.loginResponse.observe(this) { response ->
            response?.data?.let {data ->
                val entity = UserEntity(
                    loginId = data.user?.loginId ?: "",
                    userName = data.user?.userName,
                    token = data.token,
                    tenantId = data.tenantId,
                    roleCode = data.user?.roleCode,
                    userFName = data.user?.userFName,
                    userLName = data.user?.userLName,
                    userDisplayName = data.user?.userDisplayName,
                    userBaseBranchCode = data.user?.userBaseBranchCode,
                    assignedBranch = data.user?.assignedBranch,
                    authStatus = data.user?.authStatus,
                    preferLang = data.user?.preferLang
                )
                lifecycleScope.launch {
                 val insertData =    database.userDao().insert(entity)
                    insertData.let {
                        Toast.makeText(this@LoginActivity,"Data Inserted: $it",Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    fun observepreLogin() {
        viewModel.preLoginResponse.observe(this) {
            bearerToken = it?.data?.token
            Log.e("PRELOGIN", "token: $bearerToken")
            Constant.BARER_TOKEN = "Bearer $bearerToken"
            Log.e("BARER_TOKEN", "observepreLogin: $Constant.BARER_TOKEN")
            binding.loginBtn.isEnabled = bearerToken != null
        }
    }

}