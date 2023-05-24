package com.example.marks_last.database.dao

import androidx.constraintlayout.widget.Group
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Groupdao {
    @Query("select * from groups")
    fun getGroups():List<Group>

    @Query("select * from groups where id=:groupId")
    fun getGroup(groupId:Int):Group

    @Insert
    fun addGroup(group: com.example.marks_last.database.entity.Group)
}