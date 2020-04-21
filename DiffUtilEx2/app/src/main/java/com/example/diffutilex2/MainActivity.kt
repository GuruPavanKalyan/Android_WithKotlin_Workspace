package com.example.diffutilex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView
    lateinit var list: MutableList<Employee>
    lateinit var adapter: EmployeeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recyclerView)
        populateData()
    }

    private fun populateData() {
        list = mutableListOf(Employee(1, "Mastan"), Employee(2, "Vali"))
        adapter = EmployeeAdapter(this)
        adapter.submitList(list)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
    }

    fun updateList(view: View) {
        list.add(Employee(3, "Rafi"))
        list.add(Employee(4,"Lokesh"))
        list.add(Employee(5,"Sai"))
        //adapter.submitList(list)
        rv.adapter = adapter

    }
}
