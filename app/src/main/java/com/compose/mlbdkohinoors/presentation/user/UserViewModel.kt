package com.compose.mlbdkohinoors.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.mlbdkohinoors.core.extensions.Resource
import com.compose.mlbdkohinoors.domain.model.TeamMember
import com.compose.mlbdkohinoors.domain.usecase.GetTeamMembersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetTeamMembersUseCase
) : ViewModel() {

    private var _userStateFlow: MutableStateFlow<Resource<List<TeamMember>>> =
        MutableStateFlow(Resource.Empty())
    val usersFlow = _userStateFlow.asStateFlow()

    fun getUsers() {
        viewModelScope.launch {
            getUsersUseCase.execute().collect {
                _userStateFlow.value = it
            }
        }
    }

}