package com.example.mvvmnetwork.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmnetwork.R
import com.example.mvvmnetwork.data.api.User

class MainAdapter(private val users:
                  ArrayList<User>):RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

   inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            val imageView:ImageView = itemView.findViewById(R.id.imageViewAvatar)
            val textViewUserName:AppCompatTextView = itemView.findViewById(R.id.textViewUserName)
            val textViewUserEmail:AppCompatTextView = itemView.findViewById(R.id.textViewUserEmail)
            Glide.with(imageView.context)
                .load(user.avatar)
                .into(imageView)

            textViewUserName.text = user.name
            textViewUserEmail.text=user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
        )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int)= holder.bind(users[position])

    override fun getItemCount(): Int =users.size

     fun addData(list: List<User>){
         users.addAll(list)
     }

}