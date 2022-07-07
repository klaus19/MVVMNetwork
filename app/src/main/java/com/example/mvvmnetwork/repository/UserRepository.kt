package com.example.mvvmnetwork.repository

import com.example.mvvmnetwork.data.api.BaseApiResponse
import com.example.mvvmnetwork.data.api.User
import com.example.mvvmnetwork.data.model.RemoteDatasource
import com.example.mvvmnetwork.sealed.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(private val remoteDatasource: RemoteDatasource):BaseApiResponse() {

    suspend fun getUsers():Flow<Network<List<User>>>{
        return flow {
            emit(safeApiCall {
                remoteDatasource.getUsers()
            })
        }.flowOn(Dispatchers.IO)
    }
}