package com.mvvm.clean.mvvmcleanarchitecture.domain.usecases

import com.mvvm.clean.mvvmcleanarchitecture.domain.model_domain.PhotoSize_domain
import com.mvvm.clean.mvvmcleanarchitecture.domain.repo_domain.PhotoRepository
import com.mvvm.clean.mvvmcleanarchitecture.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotoListUsecase @Inject constructor(val photoRpository: PhotoRepository) {

    operator fun invoke(): Flow<NetworkResult<List<PhotoSize_domain>>> = flow {
        emit(NetworkResult.Loading())
        try {
            val photoSizes = photoRpository.getPhotoSizes()
            emit(NetworkResult.Success(photoSizes))
        } catch (e: Exception) {
            emit(NetworkResult.Error(e.message ?: "An unexpected error occurred"))
        }
    }
}