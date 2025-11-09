package com.nvozhegov.optimalworkout.domain.template

import com.nvozhegov.optimalworkout.data.model.entity.Template
import com.nvozhegov.optimalworkout.data.model.relationModel.TemplateWithExercise
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {
    suspend fun create(template: Template): Int

    suspend fun delete(template: Template)

    suspend fun createTemplateCrossRef(templateId: Int, exerciseId: Int)

    fun getAllTemplates(): Flow<List<Template>>

    fun getTemplateWithExercises(templateId: Int): Flow<List<TemplateWithExercise>>
}