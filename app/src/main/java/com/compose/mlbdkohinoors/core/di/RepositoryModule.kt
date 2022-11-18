package com.compose.mlbdkohinoors.core.di

import com.compose.mlbdkohinoors.data.mapper.TeamMemberMapper
import com.compose.mlbdkohinoors.data.remote.repository.TeamMembersRepositoryImp
import com.compose.mlbdkohinoors.data.remote.service.ApiService
import com.compose.mlbdkohinoors.domain.repository.TeamMemberRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTeamMemberRepository(
        service: ApiService,
        mapper: TeamMemberMapper
    ): TeamMemberRepository =
        TeamMembersRepositoryImp(service, mapper)
}