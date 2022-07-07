package com.example.mvvmnetwork.data.model

import com.example.mvvmnetwork.constant.Constants
import com.example.mvvmnetwork.data.api.User
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET(Constants.RANDOM_URL)
    fun getUsers():Response<List<User>>

}