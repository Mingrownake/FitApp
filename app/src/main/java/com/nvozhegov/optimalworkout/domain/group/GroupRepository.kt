package com.nvozhegov.optimalworkout.domain.group

import com.nvozhegov.optimalworkout.data.model.entity.Group
import kotlinx.coroutines.flow.Flow

interface GroupRepository {
    fun getAll(): Flow<List<Group>>
}