package com.example.mvvmnetwork.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmnetwork.data.api.User
import com.example.mvvmnetwork.repository.UserRepository
import com.example.mvvmnetwork.sealed.Network
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Mainviewmodel @Inject constructor(private val userRepository: UserRepository,
      application: Application):AndroidViewModel(application) {

          private val _response:MutableLiveData<Network<List<User>>> = MutableLiveData()

          val response:LiveData<Network<List<User>>> = _response


    fun fetchUsers() = viewModelScope.launch {

        userRepository.getUsers().collect {

            _response.value = it
        }
    }



}