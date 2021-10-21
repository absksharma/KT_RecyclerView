package com.example.kt_recyclerview.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kt_recyclerview.R

class DetailedContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_contact)

        val profileName: TextView = findViewById(R.id.nameProfile)
        val profilePhoneNo: TextView = findViewById(R.id.phoneNoProfile)
        val profileImage: ImageView = findViewById(R.id.circleImageView)

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val phoneNo = bundle.getString("phoneNo")
        val image = bundle.getInt("image")


        profileImage.setImageResource(image)
        profileName.text = name
        profilePhoneNo.text = phoneNo

    }
}