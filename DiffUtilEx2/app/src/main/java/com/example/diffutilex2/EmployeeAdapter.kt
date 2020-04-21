package com.example.diffutilex2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(val context: Context) :
    ListAdapter<Employee,EmployeeViewHolder>(EmployeeDiffUtil()) {

    class EmployeeDiffUtil : DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.emp_id == newItem.emp_id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.row, parent, false))
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val list = getItem(position)
        holder.empid.text = (list.emp_id).toString()
        holder.empname.text = (list.emp_name)

    }


}

class EmployeeViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
    val empid = itemview.findViewById<TextView>(R.id.emp_id)
    val empname = itemview.findViewById<TextView>(R.id.emp_name)

}