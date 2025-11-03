package com.nvozhegov.optimalworkout.data.repository

import com.nvozhegov.optimalworkout.data.dao.ExerciseDao
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.domain.exercise.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    val exerciseDao: ExerciseDao
) : ExerciseRepository {
    override fun getAll(): Flow<List<Exercise>> {
        return exerciseDao.getAll()
    }

    override fun getExercisesByGroupId(id: Int): Flow<List<Exercise>> {
        return exerciseDao.getExercisesByGroupId(id)
    }

    override suspend fun insert(exercise: Exercise) {
        exerciseDao.insert(exercise)
    }

    override suspend fun insertAll(exercises: List<Exercise>) {
        exerciseDao.insertAll(exercises)
    }
}