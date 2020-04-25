package com.example.cricketscoreboard

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cricketscoreboard.databinding.ActivityMainBinding
import com.example.roomdatabasetest.Databases.StudentDatabase
import com.example.roomdatabasetest.Databases.StudentDetails
import com.example.roomdatabasetest.MainViewModel
import com.example.roomdatabasetest.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)
        mainViewModel.allStudents.observe(this, Observer { list ->
            displayData(list)

        })

        dataBinding.saveButton.setOnClickListener {
            saveData()
        }
    }

    private fun displayData(list: List<StudentDetails>?) {
        val ra = RecyclerAdapter(this)
        dataBinding.recycler.adapter = ra
        dataBinding.recycler.layoutManager=LinearLayoutManager(this)
        ra.submitList(list)

    }

    private fun saveData() {
        val aScore = dataBinding.teamACore.text.toString()
        val bScore = dataBinding.teamBCore.text.toString()
        val studentDetails: StudentDetails =
            StudentDetails(teamA_Score = aScore, teamB_Score = bScore)
        mainViewModel.insert(studentDetails)
        val toast:Toast = Toast.makeText(this, "Data Insert ", Toast.LENGTH_LONG)
        toast.show()
        dataBinding.teamACore.text.clear()
        dataBinding.teamBCore.text.clear()
       

    }




}
