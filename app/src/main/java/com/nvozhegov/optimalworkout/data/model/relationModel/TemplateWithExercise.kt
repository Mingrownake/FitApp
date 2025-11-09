package com.nvozhegov.optimalworkout.data.model.relationModel

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.nvozhegov.optimalworkout.data.model.entity.TemplatesExercises
import com.nvozhegov.optimalworkout.data.model.entity.Exercise
import com.nvozhegov.optimalworkout.data.model.entity.Template

data class TemplateWithExercise(
    @Embedded val template: Template,
    @Relation(
        parentColumn = "template_id",
        entityColumn = "exercise_id",
        associateBy = Junction(TemplatesExercises::class)
    )
    val exercises: List<Exercise>
)
