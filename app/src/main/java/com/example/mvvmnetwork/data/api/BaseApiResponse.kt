package com.example.mvvmnetwork.data.api

import retrofit2.Response

abstract class BaseApiResponse {


    suspend fun <T>safeApiCall(apiCall:suspend()->Response<T>):com.example.mvvmnetwork.sealed.Network<T>{
        try {
            val response = apiCall()
            if (response.isSuccessful){
                val body = response.body()
                body?.let {
                    return com.example.mvvmnetwork.sealed.Network.Success(body)
                }
            }
            return error("${response.code()} ${response.body()}")
        }catch (e:Exception){
            return  error(e.message?:e.toString())
        }
    }

    private fun<T> error(errormessage:String):com.example.mvvmnetwork.sealed.Network<T> =
        com.example.mvvmnetwork.sealed.Network.Error("Api call failed $errormessage")

    }


