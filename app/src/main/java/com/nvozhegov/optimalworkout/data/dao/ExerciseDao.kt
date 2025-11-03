package com.nvozhegov.optimalworkout.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nvozhegov.optimalworkout.data.model.Exercise
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercises")
    fun getAll(): Flow<List<Exercise>>

    @Query("SELECT * FROM exercises where group_id = :groupId")
    fun getExercisesByGroupId(groupId: Int): Flow<List<Exercise>>

    @Insert
    suspend fun insert(exercise: Exercise)

    @Insert
    suspend fun insertAll(exercises: List<Exercise>)
}