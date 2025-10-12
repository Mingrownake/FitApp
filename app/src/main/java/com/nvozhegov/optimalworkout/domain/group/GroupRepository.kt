package com.nvozhegov.optimalworkout.domain.group

import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.data.model.Group

interface GroupRepository {
    suspend fun getAll(): List<Group>
}