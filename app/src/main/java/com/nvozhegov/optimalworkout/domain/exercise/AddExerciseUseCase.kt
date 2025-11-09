package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.entity.Exercise
import javax.inject.Inject

class AddExerciseUseCase @Inject constructor (
    val exerciseRepository: ExerciseRepository
) {
    suspend operator fun invoke(exercise: Exercise) {
        exerciseRepository.insert(exercise)
    }
}