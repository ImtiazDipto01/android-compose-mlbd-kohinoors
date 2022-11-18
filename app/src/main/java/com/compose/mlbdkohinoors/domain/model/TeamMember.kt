package com.compose.mlbdkohinoors.domain.model

import com.google.gson.annotations.SerializedName

data class TeamMember(
    val name: String,
    val id: Int,
    val githubLogin: String?,
    val designation: String?,
    val tag: String?,
    val avatar: String?
)
