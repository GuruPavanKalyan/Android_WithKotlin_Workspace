package com.example.roomdatabasetest.Databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentDetails::class],version = 1,exportSchema = false)
abstract class StudentDatabase : RoomDatabase(){

    abstract val studentDao :StudentDao

    companion object{

        @Volatile
        var INSTANCE: StudentDatabase?=null

        fun getInstance(context: Context):StudentDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context,
                        StudentDatabase::class.java,
                        "Studentdb").fallbackToDestructiveMigration().allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}