package com.nvozhegov.optimalworkout.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.nvozhegov.optimalworkout.data.model.Group

@Dao
interface GroupDao {
    @Query("select * from `groups`")
    suspend fun getAllGroups(): List<Group>
}