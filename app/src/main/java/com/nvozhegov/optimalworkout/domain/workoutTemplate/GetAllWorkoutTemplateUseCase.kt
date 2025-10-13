package com.nvozhegov.optimalworkout.domain.workoutTemplate

import com.nvozhegov.optimalworkout.data.model.WorkoutTemplate
import javax.inject.Inject

class GetAllWorkoutTemplateUseCase @Inject constructor(
    val workoutRepository: WorkoutTemplateRepository
) {
    suspend fun invoke(): List<WorkoutTemplate> {
        return workoutRepository.getAll()
    }
}