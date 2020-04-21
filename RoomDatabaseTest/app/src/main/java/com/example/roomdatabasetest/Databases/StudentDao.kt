package com.example.roomdatabasetest.Databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    fun insert(studentDetails: StudentDetails)

    @Query("select *from student_details")
    fun getAll(): LiveData<List<StudentDetails>>

    @Query("select *from student_details where student_id LIKE :id")
    fun getDatawithid(id:Int):LiveData<List<StudentDetails>>
}