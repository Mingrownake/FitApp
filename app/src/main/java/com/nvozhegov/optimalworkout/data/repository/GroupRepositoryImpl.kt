package com.nvozhegov.optimalworkout.data.repository

import com.nvozhegov.optimalworkout.data.dao.GroupDao
import com.nvozhegov.optimalworkout.data.model.Group
import com.nvozhegov.optimalworkout.domain.group.GroupRepository
import javax.inject.Inject

class GroupRepositoryImpl @Inject constructor(
    val groupDao: GroupDao
) : GroupRepository {
    override suspend fun getAll(): List<Group> {
        return groupDao.getAllGroups()
    }
}