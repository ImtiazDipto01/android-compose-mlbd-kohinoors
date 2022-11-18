package com.compose.mlbdkohinoors.domain.usecase

import com.compose.mlbdkohinoors.core.extensions.Resource
import com.compose.mlbdkohinoors.domain.model.TeamMember
import com.compose.mlbdkohinoors.domain.repository.TeamMemberRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeamMembersUseCase @Inject constructor(
    private val repository: TeamMemberRepository
) {
    suspend fun execute(): Flow<Resource<List<TeamMember>>> = repository.getTeamMembers()
}