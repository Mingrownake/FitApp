package com.nvozhegov.optimalworkout.domain.workoutTemplate

import com.nvozhegov.optimalworkout.data.model.entity.WorkoutTemplate
import javax.inject.Inject

class GetAllWorkoutTemplateUseCase @Inject constructor(
    private val workoutRepository: WorkoutTemplateRepository
) {
    suspend operator fun invoke(): List<WorkoutTemplate> {
        return workoutRepository.getAll()
    }
}