package com.salti.klinikappkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StartScreen2 : AppCompatActivity() {

    private lateinit var btnGetStart : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start_screen2)

        btnGetStart = findViewById(R.id.btnGetStarted)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnGetStart.setOnClickListener(){
            val intentPassingData = Intent(this@StartScreen2,
                PageLogin::class.java)
            startActivity(intentPassingData)
        }
    }
}