package com.nvozhegov.optimalworkout.domain.group

import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.data.model.Group
import kotlinx.coroutines.flow.Flow

interface GroupRepository {
    fun getAll(): Flow<List<Group>>
}