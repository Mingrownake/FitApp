package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.Exercise
import javax.inject.Inject

class GetByIdUseCase @Inject constructor (
    val exerciseRepository: ExerciseRepository
) {
    suspend operator fun invoke(id: Int): Exercise {
        return exerciseRepository.getById(id)
    }
}