package com.nvozhegov.optimalworkout.data.repository

import com.nvozhegov.optimalworkout.data.dao.WorkoutTemplateDao
import com.nvozhegov.optimalworkout.data.model.entity.WorkoutTemplate
import com.nvozhegov.optimalworkout.domain.workoutTemplate.WorkoutTemplateRepository
import javax.inject.Inject

class WorkoutTemplateRepositoryImpl @Inject constructor(
    val workoutTemplateDao: WorkoutTemplateDao
) : WorkoutTemplateRepository {
    override suspend fun getAll(): List<WorkoutTemplate> {
        return workoutTemplateDao.getAllTemplates()
    }

    override suspend fun getById(id: Int): WorkoutTemplate {
        return workoutTemplateDao.getTemplateById(id)
    }

    override suspend fun insert(template: WorkoutTemplate) {
        workoutTemplateDao.insert(template)
    }
}