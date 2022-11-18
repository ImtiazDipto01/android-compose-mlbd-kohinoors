package com.compose.mlbdkohinoors.data.remote.repository

import com.compose.mlbdkohinoors.core.extensions.Resource
import com.compose.mlbdkohinoors.core.extensions.safeApiCall
import com.compose.mlbdkohinoors.data.mapper.TeamMemberMapper
import com.compose.mlbdkohinoors.data.remote.service.ApiService
import com.compose.mlbdkohinoors.domain.model.TeamMember
import com.compose.mlbdkohinoors.domain.repository.TeamMemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class TeamMembersRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val mapper: TeamMemberMapper
) : TeamMemberRepository {

    override suspend fun getTeamMembers(): Flow<Resource<List<TeamMember>>> = safeApiCall {
        apiService.getTeamMembers()
    }.transform {
        when(it){
            is Resource.Success -> emit(Resource.Success(mapper.mapFromDtoList(it.data)))
            else -> emit(it as Resource<List<TeamMember>>)
        }
    }

}