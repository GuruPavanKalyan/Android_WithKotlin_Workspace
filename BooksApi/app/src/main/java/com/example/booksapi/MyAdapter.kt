package com.example.booksapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context, val list: MutableList<MyData>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.myrow,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
       holder.t.text = (list.get(position).title)
        Picasso.with(context).load(list.get(position).imgUrl).placeholder(R.drawable.loading).into(holder.iv);
    }


}

class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val t = itemView.findViewById<TextView>(R.id.title)
    val iv = itemView.findViewById<ImageView>(R.id.image)

}