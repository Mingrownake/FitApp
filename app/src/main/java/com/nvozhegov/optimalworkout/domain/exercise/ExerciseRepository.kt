package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.entity.Exercise
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {
    fun getAll(): Flow<List<Exercise>>
    fun getExercisesByGroupId(id: Int): Flow<List<Exercise>>
    suspend fun insert(exercise: Exercise)
    suspend fun insertAll(exercises: List<Exercise>)
}