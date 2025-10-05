package com.nvozhegov.optimalworkout.data.repository

import com.nvozhegov.optimalworkout.data.dao.ExerciseDao
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.domain.exercise.ExerciseRepository
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    val exerciseDao: ExerciseDao
) : ExerciseRepository {
    override suspend fun getAll(): List<Exercise> {
        return exerciseDao.getAll()
    }

    override suspend fun getById(id: Int): Exercise {
        return exerciseDao.getById(id)
    }

    override suspend fun insert(exercise: Exercise) {
        exerciseDao.insert(exercise)
    }

    override suspend fun insertAll(exercises: List<Exercise>) {
        exerciseDao.insertAll(exercises)
    }
}