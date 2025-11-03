package com.nvozhegov.optimalworkout.domain.exercise

import com.nvozhegov.optimalworkout.data.model.Exercise
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetExercisesByGroupIdUseCase @Inject constructor (
    val exerciseRepository: ExerciseRepository
) {
    operator fun invoke(id: Int): Flow<List<Exercise>> {
        return exerciseRepository.getExercisesByGroupId(id)
    }
}