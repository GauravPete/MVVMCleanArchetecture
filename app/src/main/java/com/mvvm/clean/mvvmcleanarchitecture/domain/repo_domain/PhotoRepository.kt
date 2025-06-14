package com.mvvm.clean.mvvmcleanarchitecture.domain.repo_domain


import com.mvvm.clean.mvvmcleanarchitecture.domain.model_domain.PhotoSize_domain

interface PhotoRepository {
    suspend fun getPhotoSizes(): List<PhotoSize_domain>

}