package com.nvozhegov.optimalworkout.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nvozhegov.optimalworkout.data.model.WorkoutTemplate

@Dao
interface WorkoutTemplateDao {

    @Query("SELECT * FROM workout_templates")
    suspend fun getAllTemplates() : List<WorkoutTemplate>

    @Query("SELECT * FROM workout_templates where id = :id")
    suspend fun getTemplateById(id: Int) : WorkoutTemplate

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(template: WorkoutTemplate)
}