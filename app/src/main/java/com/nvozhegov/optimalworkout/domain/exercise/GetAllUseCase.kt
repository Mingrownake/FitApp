package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.Exercise
import javax.inject.Inject

class GetAllUseCase @Inject constructor (
    val exerciseRepository: ExerciseRepository
) {
    suspend operator fun invoke(): List<Exercise> {
        return exerciseRepository.getAll()
    }
}