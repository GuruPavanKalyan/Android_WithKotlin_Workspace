package com.example.cricketscoreboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasetest.Databases.StudentDetails

class RecyclerAdapter(val context: Context) :
    ListAdapter<StudentDetails, RecyclerViewHolder>(StudentDiffutil()) {

    class StudentDiffutil : DiffUtil.ItemCallback<StudentDetails>() {
        override fun areItemsTheSame(
            oldItem: StudentDetails,
            newItem: StudentDetails
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: StudentDetails,
            newItem: StudentDetails
        ): Boolean {
            return oldItem == newItem
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        return RecyclerViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val l = getItem(position)
        holder.stid.text = (l.id).toString()
        holder.sname.text = (l.teamA_Score).toString()
        holder.sage.text = (l.teamB_Score).toString()
    }

}

class RecyclerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
    val stid = itemview.findViewById<TextView>(R.id.stid)
    val sname = itemview.findViewById<TextView>(R.id.stName)
    val sage = itemview.findViewById<TextView>(R.id.stAge)

}