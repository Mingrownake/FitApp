package com.nvozhegov.optimalworkout.domain.template

import com.nvozhegov.optimalworkout.data.model.Template
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTemplatesUseCase @Inject constructor(
    val templateRepository: TemplateRepository
) {
    suspend operator fun invoke(): Flow<List<Template>> {
        return templateRepository.getAllTemplates()
    }
}