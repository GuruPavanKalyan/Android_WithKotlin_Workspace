package com.example.roomdatabasetest.Databases

import android.app.Application
import androidx.lifecycle.LiveData

class StudentRepository(application: Application){
    private val studentDao:StudentDao
    private val studentsList:LiveData<List<StudentDetails>>
    private val singleStudentData:LiveData<List<StudentDetails>>
    init {
        val studentDatabase:StudentDatabase = StudentDatabase.getInstance(application)
        studentDao = studentDatabase.studentDao
        studentsList = studentDao.getAll()
        singleStudentData = studentDao.getDatawithid(0)
    }

    fun getAll():LiveData<List<StudentDetails>>{

        return studentsList
    }

    fun insert(studentDetails: StudentDetails){
        studentDao.insert(studentDetails)
    }

    fun getDatawithid(id:Int):LiveData<List<StudentDetails>>{
        return singleStudentData
    }
}