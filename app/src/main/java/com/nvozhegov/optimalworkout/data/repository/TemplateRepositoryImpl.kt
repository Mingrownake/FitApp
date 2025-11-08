package com.nvozhegov.optimalworkout.data.repository

import com.nvozhegov.optimalworkout.data.dao.TemplateDao
import com.nvozhegov.optimalworkout.data.model.Template
import com.nvozhegov.optimalworkout.data.model.TemplateExerciseCrossRef
import com.nvozhegov.optimalworkout.data.model.TemplateWithExercise
import com.nvozhegov.optimalworkout.domain.template.TemplateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TemplateRepositoryImpl @Inject constructor(
    val templateDao: TemplateDao
) : TemplateRepository {
    override suspend fun create(template: Template): Int {
        return withContext(Dispatchers.IO) {
            templateDao.create(template).toInt()
        }
    }

    override suspend fun createTemplateCrossRef(templateId: Int, exerciseId: Int) {
        withContext(Dispatchers.IO) {
            templateDao.createTemplateCrossRef(templateId = templateId, exerciseId = exerciseId)
        }
    }

    override fun getAllTemplates(): Flow<List<Template>> {
        return templateDao.getAllTemplates()
    }

    override fun getTemplateWithExercises(templateId: Int): Flow<List<TemplateWithExercise>> {
        return templateDao.getTemplateWithExercises(templateId)
    }


}