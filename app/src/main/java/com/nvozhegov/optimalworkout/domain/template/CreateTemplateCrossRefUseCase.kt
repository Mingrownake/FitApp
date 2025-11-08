package com.nvozhegov.optimalworkout.domain.template

import com.nvozhegov.optimalworkout.data.model.Template
import com.nvozhegov.optimalworkout.data.model.TemplateExerciseCrossRef
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