package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.Exercise
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {
    fun getAll(): Flow<List<Exercise>>
    suspend fun getById(id: Int): Exercise
    suspend fun insert(exercise: Exercise)
    suspend fun insertAll(exercises: List<Exercise>)
}