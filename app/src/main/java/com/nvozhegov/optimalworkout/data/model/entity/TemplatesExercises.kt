package com.nvozhegov.optimalworkout.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    primaryKeys = ["template_id", "exercise_id"],
    foreignKeys = [
        ForeignKey(
            entity = Template::class,
            parentColumns = ["template_id"],
            childColumns = ["template_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("template_id"), Index("exercise_id")],
    tableName = "templates_exercises"
)
data class TemplatesExercises(
    @ColumnInfo(name = "template_id")
    val templateId: Int,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Int
)