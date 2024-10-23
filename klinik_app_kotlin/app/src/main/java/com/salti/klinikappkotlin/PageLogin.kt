package com.salti.klinikappkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.salti.klinikappkotlin.screen.HomeDoctorsActivity

class PageLogin : AppCompatActivity() {

    private lateinit var txtSignUp : TextView
    private lateinit var btnSigIn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_login)

        txtSignUp = findViewById(R.id.txtSignUp)
        btnSigIn = findViewById(R.id.btnSignInHD)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtSignUp.setOnClickListener(){
            val intentPassingData = Intent(this@PageLogin,
                PageRegister::class.java)
            startActivity(intentPassingData)
        }
        btnSigIn.setOnClickListener(){
            val intentPassingData = Intent(this@PageLogin,
                HomeDoctorsActivity::class.java)
            startActivity(intentPassingData)
        }
    }
}