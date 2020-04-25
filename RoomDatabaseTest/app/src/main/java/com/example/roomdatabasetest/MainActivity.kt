package com.example.roomdatabasetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasetest.Databases.StudentDatabase
import com.example.roomdatabasetest.Databases.StudentDetails

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var id: EditText
    lateinit var rv: RecyclerView
    lateinit var studentDatabase: StudentDatabase
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)
        mainViewModel.allStudents.observe(this, Observer { list ->
            displayData(list)
        })
    }

    private fun initViews() {
        name = findViewById(R.id.stname)
        age = findViewById(R.id.stAge)
        rv = findViewById(R.id.recyclerview)
        id = findViewById(R.id.idofstudent)
    }

    fun save(view: View) {
        val n = name.text.toString()
        val a = (age.text.toString()).toInt()
        val studentDetails: StudentDetails = StudentDetails(student_name = n, student_age = a)
        mainViewModel.insert(studentDetails)
        Toast.makeText(this, "Data Insert ", Toast.LENGTH_LONG).show()
    }

    private fun displayData(list: List<StudentDetails>) {
        val ra = RecyclerAdapter(this)
        rv.adapter = ra
        ra.submitList(list)

    }

    fun getData(view: View) {
        val stid = (id.text.toString()).toInt()

    }

    class RecyclerAdapter(val context: Context) : ListAdapter<StudentDetails, RecyclerViewHolder>(StudentDiffutil()) {


        class StudentDiffutil:DiffUtil.ItemCallback<StudentDetails>(){
            override fun areItemsTheSame(
                oldItem: StudentDetails,
                newItem: StudentDetails
            ): Boolean {
                return oldItem.student_id == newItem.student_id
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
            holder.stid.text = (l.student_id).toString()
            holder.sname.text = (l.student_name).toString()
            holder.sage.text = (l.student_age).toString()
        }

    }

    class RecyclerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val stid = itemview.findViewById<TextView>(R.id.stid)
        val sname = itemview.findViewById<TextView>(R.id.stName)
        val sage = itemview.findViewById<TextView>(R.id.stAge)

    }


}
