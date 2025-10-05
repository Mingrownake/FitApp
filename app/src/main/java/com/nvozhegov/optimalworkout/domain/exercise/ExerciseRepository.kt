package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.Exercise

interface ExerciseRepository {
    suspend fun getAll(): List<Exercise>
    suspend fun getById(id: Int): Exercise
    suspend fun insert(exercise: Exercise)
    suspend fun insertAll(exercises: List<Exercise>)
}