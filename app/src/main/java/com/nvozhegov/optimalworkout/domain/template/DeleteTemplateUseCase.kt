package com.nvozhegov.optimalworkout.domain.template

import com.nvozhegov.optimalworkout.data.model.entity.Template
import javax.inject.Inject

class DeleteTemplateUseCase @Inject constructor(
    val templateRepository: TemplateRepository
) {
    suspend operator fun invoke(template: Template) {
        templateRepository.delete(template)
    }
}