package com.example.bookproject.BaseActivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookproject.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base)
        setUpStatusBar()
    }

    fun setUpStatusBar(colorId:Int=R.color.background){
        window.statusBarColor=ContextCompat.getColor(this,colorId)

    }
}