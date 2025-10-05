package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.Exercise
import javax.inject.Inject

class AddAllExerciseUseCase@Inject constructor (
    val exerciseRepository: ExerciseRepository
) {
    suspend operator fun invoke(exercises: List<Exercise>) {
        exerciseRepository.insertAll(exercises)
    }
}