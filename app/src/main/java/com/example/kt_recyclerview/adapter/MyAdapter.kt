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
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_items,
            parent, false
        )
        return MyViewHolder(itemView,mListener)
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

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imageId: ImageView = itemView.findViewById(R.id.circleImage)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val phoneNo: TextView = itemView.findViewById(R.id.tvPhoneNumber)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }
}