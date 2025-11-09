package com.nvozhegov.optimalworkout.data.model.relationModel

import androidx.room.Embedded
import androidx.room.Relation
import com.nvozhegov.optimalworkout.data.model.entity.Exercise
import com.nvozhegov.optimalworkout.data.model.entity.Group

data class GroupWithExercise(
    @Embedded val group: Group,
    @Relation(
        parentColumn = "group_id",
        entityColumn = "group_id"
    )
    val exerciseList: List<Exercise>
)
