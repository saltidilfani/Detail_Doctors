package com.salti.klinikappkotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailKlinik : AppCompatActivity() {

    private lateinit var imageDetailDoctor : ImageView
    private lateinit var txtDetailNamaDoctor : TextView
    private lateinit var txtDetailSpesDoctor : TextView
    private lateinit var txtDetailJumlahReview: TextView
    private lateinit var detailRating : RatingBar
    private lateinit var txtDetailJumlahRating: TextView
    private lateinit var txtDetailDate : TextView
    private lateinit var txtDetailTime : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_klinik)

        imageDetailDoctor = findViewById(R.id.imgDoctor)
        txtDetailNamaDoctor = findViewById(R.id.txtNamaDoctor)
        txtDetailSpesDoctor = findViewById(R.id.txtSpesDoctor)
        txtDetailJumlahReview = findViewById(R.id.txtReviewDoctor)
        detailRating = findViewById(R.id.rating)
        txtDetailJumlahRating = findViewById(R.id.txtJumlahRating)
        txtDetailDate = findViewById(R.id.txtDDate)
        txtDetailTime = findViewById(R.id.txtDTime)


        //get data
        val imgDoctor = intent.getIntExtra("Image Doctor", 0)
        val namaDoctor = intent.getStringExtra("Nama Doctor")
        val spesDoctor = intent.getStringExtra("Spes Doctor")
        val jumlahReview = intent.getStringExtra("Jumlah Review")
        val jumlahRating = intent.getStringExtra("Jumlah Rating")
        val date = intent.getStringExtra("Date")
        val time = intent.getStringExtra("Time")

        //set data ke widget
        imageDetailDoctor.setImageResource(imgDoctor)
        txtDetailNamaDoctor.setText(namaDoctor)
        txtDetailSpesDoctor.setText(spesDoctor)
        txtDetailJumlahReview.setText(jumlahReview)
        txtDetailJumlahRating.setText(jumlahRating)
        txtDetailDate.setText(date)
        txtDetailTime.setText(time)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}