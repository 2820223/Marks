package com.example.marks_last.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.itschool.marks.database.entity.Subject

@Dao
interface SubjectDao {
    @Query("select * from subjects")
    fun getSubjects():List<Subject>
    @Query("select * from subjects where id=:subjectId")
    fun getSubject(subjectId:Int):Subject

    @Insert
    fun addSubject(subject: Subject)
}