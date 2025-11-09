package com.nvozhegov.optimalworkout.data.repository

import com.nvozhegov.optimalworkout.data.dao.GroupDao
import com.nvozhegov.optimalworkout.data.model.entity.Group
import com.nvozhegov.optimalworkout.domain.group.GroupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GroupRepositoryImpl @Inject constructor(
    val groupDao: GroupDao
) : GroupRepository {
    override fun getAll(): Flow<List<Group>> {
        return groupDao.getAllGroups()
    }
}