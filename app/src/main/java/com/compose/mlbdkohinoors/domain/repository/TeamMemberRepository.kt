package com.compose.mlbdkohinoors.domain.repository

import com.compose.mlbdkohinoors.core.extensions.Resource
import com.compose.mlbdkohinoors.data.remote.dto.TeamMemberResponse
import com.compose.mlbdkohinoors.domain.model.TeamMember
import kotlinx.coroutines.flow.Flow

interface TeamMemberRepository {
    suspend fun getTeamMembers(): Flow<Resource<List<TeamMember>>>
}