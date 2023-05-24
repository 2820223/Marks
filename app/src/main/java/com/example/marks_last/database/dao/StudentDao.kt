package com.example.marks_last.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("select * from students")
    fun getStudents():List<Student>


    @Query("select * from students where group_id = :groupId")
    fun getStudents(groupId:Int):List<Student>

    @Insert
    fun addStudent(student: Student)
    @Query("select * from students where id = :id")
    fun getStudent(id : Int):Student

}