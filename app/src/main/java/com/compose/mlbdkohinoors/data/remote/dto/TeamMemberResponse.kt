package com.compose.mlbdkohinoors.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TeamMemberResponse(

	@field:SerializedName("github_login")
	val githubLogin: String? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("designation")
	val designation: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null
)
