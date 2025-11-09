package com.nvozhegov.optimalworkout.domain.workoutTemplate

import com.nvozhegov.optimalworkout.data.model.entity.WorkoutTemplate
import javax.inject.Inject

class GetByIdWorkoutTemplateUseCase @Inject constructor(
    val workoutRepository: WorkoutTemplateRepository
) {
    suspend fun invoke(id: Int): WorkoutTemplate {
        return workoutRepository.getById(id)
    }
}