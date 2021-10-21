package com.example.kt_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kt_recyclerview.R
import com.example.kt_recyclerview.adapter.MyAdapter.MyViewHolder
import com.example.kt_recyclerview.model.Contacts

class MyAdapter(private val contactsList: ArrayList<Contacts>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_items,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = contactsList[position]
        holder.imageId.setImageResource(currentItem.image)
        holder.name.text = currentItem.name
        holder.phoneNo.text = currentItem.phoneNo
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageId: ImageView = itemView.findViewById(R.id.circleImage)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val phoneNo: TextView = itemView.findViewById(R.id.tvPhoneNumber)
    }
}