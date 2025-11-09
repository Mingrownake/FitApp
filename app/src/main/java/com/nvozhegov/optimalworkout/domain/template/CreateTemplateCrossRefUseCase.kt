package com.nvozhegov.optimalworkout.domain.template

import javax.inject.Inject

class CreateTemplateCrossRefUseCase @Inject constructor(
    val templateRepository: TemplateRepository
) {
    suspend operator fun invoke(templateId: Int, exerciseId: Int) {
        return templateRepository.createTemplateCrossRef(
            templateId = templateId,
            exerciseId = exerciseId
        )
    }
}