package com.nvozhegov.optimalworkout.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TemplateWithExercise(
    @Embedded val template: Template,
    @Relation(
        parentColumn = "template_id",
        entityColumn = "exercise_id",
        associateBy = Junction(TemplateExerciseCrossRef::class)
    )
    val exercises: List<Exercise>
)
