package com.nvozhegov.optimalworkout.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nvozhegov.optimalworkout.data.model.Group
import com.nvozhegov.optimalworkout.data.model.GroupWithExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDao {
    @Query("select * from `groups`")
    fun getAllGroups(): Flow<List<Group>>

    @Transaction
    @Query("SELECT * FROM `groups`")
    fun getGroupsWithExercise(): List<GroupWithExercise>
}