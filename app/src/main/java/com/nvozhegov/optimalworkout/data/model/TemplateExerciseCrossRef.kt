package com.nvozhegov.optimalworkout.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index

@Entity(
    primaryKeys = ["template_id", "exercise_id"],
    indices = [Index("template_id"), Index("exercise_id")],
    tableName = "template_exercise_cross_ref"
)
data class TemplateExerciseCrossRef(
    @ColumnInfo(name = "template_id")
    val templateId: Int,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Int
)
