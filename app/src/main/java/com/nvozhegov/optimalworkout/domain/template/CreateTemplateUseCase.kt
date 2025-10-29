package com.nvozhegov.optimalworkout.domain.template

import com.nvozhegov.optimalworkout.data.model.Template
import javax.inject.Inject

class CreateTemplateUseCase @Inject constructor(
    val templateRepository: TemplateRepository
) {
    suspend operator fun invoke(template: Template) {
        templateRepository.create(template)
    }
}
