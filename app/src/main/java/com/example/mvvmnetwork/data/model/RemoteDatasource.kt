package com.example.mvvmnetwork.data.model

import javax.inject.Inject

class RemoteDatasource @Inject constructor(private val apiService: ApiService) {

     fun getUsers() = apiService.getUsers()
}