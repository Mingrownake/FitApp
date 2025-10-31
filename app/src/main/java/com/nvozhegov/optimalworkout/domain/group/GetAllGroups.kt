package com.nvozhegov.optimalworkout.domain.group

import com.nvozhegov.optimalworkout.data.model.Group
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllGroups @Inject constructor(
    private val groupRepository: GroupRepository
) {
    operator fun invoke(): Flow<List<Group>> {
        return groupRepository.getAll()
    }
}