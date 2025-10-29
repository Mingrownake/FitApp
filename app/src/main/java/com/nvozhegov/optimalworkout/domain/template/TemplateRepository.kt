package com.nvozhegov.optimalworkout.domain.template

import com.nvozhegov.optimalworkout.data.model.Template
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {
    suspend fun create(template: Template)

    fun getAllTemplates(): Flow<List<Template>>
}