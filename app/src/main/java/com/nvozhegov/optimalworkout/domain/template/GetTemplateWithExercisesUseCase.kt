package com.nvozhegov.optimalworkout.domain.template

import com.nvozhegov.optimalworkout.data.model.relationModel.TemplateWithExercise
import kotlinx.coroutines.flow.Flow

class GetTemplateWithExercisesUseCase(
    val templateRepository: TemplateRepository
) {
    operator fun invoke(templateId: Int): Flow<List<TemplateWithExercise>> {
        return templateRepository.getTemplateWithExercises(templateId)
    }
}