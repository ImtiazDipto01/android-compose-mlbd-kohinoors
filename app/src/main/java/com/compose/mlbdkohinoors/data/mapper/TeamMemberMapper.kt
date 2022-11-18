package com.compose.mlbdkohinoors.data.mapper

import com.compose.mlbdkohinoors.core.extensions.EntityMapper
import com.compose.mlbdkohinoors.data.remote.dto.TeamMemberResponse
import com.compose.mlbdkohinoors.domain.model.TeamMember
import javax.inject.Inject

class TeamMemberMapper @Inject constructor(): EntityMapper<TeamMemberResponse, TeamMember>() {

    override fun mapFromDto(dto: TeamMemberResponse): TeamMember {
        return TeamMember(
            id = dto.id,
            name = dto.name,
            githubLogin = dto.githubLogin,
            designation = dto.designation,
            tag = dto.tag,
            avatar = dto.avatar
        )
    }

    override fun mapToDto(domainModel: TeamMember): TeamMemberResponse {
        return TeamMemberResponse(
            id = domainModel.id,
            name = domainModel.name,
            githubLogin = domainModel.githubLogin,
            designation = domainModel.designation,
            tag = domainModel.tag,
            avatar = domainModel.avatar
        )
    }

    override fun mapFromDtoList(dtoList: List<TeamMemberResponse>): List<TeamMember> =
        dtoList.map { mapFromDto(it) }

}