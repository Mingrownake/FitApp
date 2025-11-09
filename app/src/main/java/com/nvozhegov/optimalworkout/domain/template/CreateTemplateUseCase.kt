package com.nvozhegov.optimalworkout.domain.template

import com.nvozhegov.optimalworkout.data.model.entity.Template
import javax.inject.Inject

class CreateTemplateUseCase @Inject constructor(
    val templateRepository: TemplateRepository
) {
    suspend operator fun invoke(template: Template): Int {
        return templateRepository.create(template)
    }
}
