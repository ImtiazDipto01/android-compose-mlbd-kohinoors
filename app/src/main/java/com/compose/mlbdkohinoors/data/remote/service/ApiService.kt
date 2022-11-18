package com.compose.mlbdkohinoors.data.remote.service

import com.compose.mlbdkohinoors.data.remote.dto.TeamMemberResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("243bd8cd5d7f490ba813")
    suspend fun getTeamMembers(): Response<List<TeamMemberResponse>>
}