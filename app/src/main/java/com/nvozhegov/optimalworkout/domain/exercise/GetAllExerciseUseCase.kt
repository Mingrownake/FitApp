package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.entity.Exercise
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllExerciseUseCase @Inject constructor (
    val exerciseRepository: ExerciseRepository
) {
    operator fun invoke(): Flow<List<Exercise>> {
        return exerciseRepository.getAll()
    }
}