package com.example.bookproject.MasterActivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookproject.R
import com.example.bookproject.databinding.ActivityMasterBinding

class MasterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMasterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasterBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}