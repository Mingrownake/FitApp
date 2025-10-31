package com.nvozhegov.optimalworkout.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class GroupWithExercise(
    @Embedded val group: Group,
    @Relation(
        parentColumn = "id",
        entityColumn = "group_id"
    )
    val exerciseList: List<Exercise>
)
