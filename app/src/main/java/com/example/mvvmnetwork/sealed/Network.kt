package com.example.mvvmnetwork.sealed

sealed class Network<T>(
    val data: T? = null,
    val message: String?=null
){


    class Success<T>(data: T):Network<T>(data)

    class Error<T>(message: String,data: T? = null):
        Network<T>(data, message)

    class Loading<T>:Network<T>()


}
