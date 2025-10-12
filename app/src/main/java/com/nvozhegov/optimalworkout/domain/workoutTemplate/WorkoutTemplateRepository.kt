package com.nvozhegov.optimalworkout.domain.workoutTemplate

import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.data.model.WorkoutTemplate

interface WorkoutTemplateRepository {
    suspend fun getAll(): List<WorkoutTemplate>
    suspend fun getById(id: Int): WorkoutTemplate
    suspend fun insert(template: WorkoutTemplate)
}