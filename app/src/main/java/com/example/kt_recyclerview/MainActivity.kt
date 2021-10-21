package com.example.kt_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kt_recyclerview.adapter.MyAdapter
import com.example.kt_recyclerview.model.Contacts

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newContactsList: ArrayList<Contacts>
    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>
    lateinit var phoneNo: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.facebook_avatar,
        )
        name = arrayOf(
            "Adrian Gonzales",
            "Drew Vaughn",
            "Norman Ballard",
            "Sergio Richardson",
            "Kim Richards",
            "Sylvester Becker",
            "Jimmie Fisher",
            "Lucas Logan",
            "Ellen Aguilar",
        )
        phoneNo = arrayOf(
            "+1 320-769-9784",
            "+1 202-584-2894",
            "+1 225-756-1704",
            "+1 337-398-8078",
            "+1 582-222-3174",
            "+1 505-644-2467",
            "+1 239-711-6616",
            "+1 505-644-8922",
            "+1 402-233-3734"
        )

        newRecyclerView = findViewById(R.id.rvContacts)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newContactsList = arrayListOf<Contacts>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in name.indices) {
            val contact = Contacts(name[i], phoneNo[i], imageId[i])
            newContactsList.add(contact)
        }
        newRecyclerView.adapter = MyAdapter(newContactsList)
    }
}