package com.salti.klinikappkotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.salti.klinikappkotlin.DetailKlinik
import com.salti.klinikappkotlin.R
import com.salti.klinikappkotlin.model.ModelListDoctors
import com.salti.klinikappkotlin.screen.HomeDoctorsActivity


class ListDoctorsAdapter (
    val getDetailKlinik: HomeDoctorsActivity,
    val itemDoctorList: List<ModelListDoctors>
) :
    RecyclerView.Adapter<ListDoctorsAdapter.MyViewHolder>(){
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItemDoctor : ImageView = itemView.findViewById(R.id.imgDoctor)
        var txtNamaDoctor : TextView = itemView.findViewById(R.id.txtNamaDoctor)
        var txtSpesDoctor : TextView = itemView.findViewById(R.id.txtSpesDoctor)
        var txtReviewDoctor : TextView = itemView.findViewById(R.id.txtReviewDoctor)
        var txtJumlahRating : TextView = itemView.findViewById(R.id.txtJumlahRating)
        val cardKlinik : CardView = itemView.findViewById(R.id.cardKlinik)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_doctor, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemDoctorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemDoctorList[position]
        holder.imgItemDoctor.setImageResource(currentItem.ImgDoctor)
        holder.txtNamaDoctor.text = currentItem.NamaDoctor
        holder.txtSpesDoctor.text = currentItem.SpesDoctor
        holder.txtReviewDoctor.text = currentItem.JumlahReview
        holder.txtJumlahRating.text = currentItem.JumlahRating

        holder.cardKlinik.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getDetailKlinik, DetailKlinik::class.java)
            //put extra
            intent.putExtra("Image Doctor", itemDoctorList[position].ImgDoctor)
            intent.putExtra("Nama Doctor", itemDoctorList[position].NamaDoctor)
            intent.putExtra("Spes Doctor", itemDoctorList[position].SpesDoctor)
            intent.putExtra("Jumlah Review", itemDoctorList[position].JumlahReview)
            intent.putExtra("Jumlah Rating", itemDoctorList[position].JumlahRating)
            intent.putExtra("Date", itemDoctorList[position].date)
            intent.putExtra("Time", itemDoctorList[position].time)

            //intent.putExtra("judul",itemList[position].judul)
            // start pindah ke detail
            getDetailKlinik.startActivity(intent)

            Toast.makeText(getDetailKlinik,itemDoctorList[position].NamaDoctor, Toast.LENGTH_SHORT).show()
        }
    }
}