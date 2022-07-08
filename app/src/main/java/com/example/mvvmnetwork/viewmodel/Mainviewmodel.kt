package com.example.mvvmnetwork.viewmodel


import androidx.lifecycle.*
import com.example.mvvmnetwork.data.api.User
import com.example.mvvmnetwork.repository.UserRepository
import com.example.mvvmnetwork.sealed.Network
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Mainviewmodel @Inject internal constructor(private val userRepository: UserRepository,
      ):ViewModel() {

          private val _response:MutableLiveData<Network<List<User>>> = MutableLiveData()

          val response:LiveData<Network<List<User>>> = _response


    fun getUsers() = viewModelScope.launch {

        userRepository.getUsers().collect {

            _response.value = it
        }
    }



}