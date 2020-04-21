package com.example.roomdatabasetest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomdatabasetest.Databases.StudentDatabase
import com.example.roomdatabasetest.Databases.StudentDetails
import com.example.roomdatabasetest.Databases.StudentRepository

class MainViewModel(application: Application):AndroidViewModel(application) {

    val studentRepository: StudentRepository
    val allStudents: LiveData<List<StudentDetails>>
    val singlestudent:LiveData<List<StudentDetails>>

    init {
        studentRepository = StudentRepository(application)
        allStudents = studentRepository.getAll()
        singlestudent = studentRepository.getDatawithid(0)
    }

    fun insert(studentDetails: StudentDetails) {
        studentRepository.insert(studentDetails)
    }

    fun getdata(id:Int):LiveData<List<StudentDetails>>{
        return singlestudent
    }
}