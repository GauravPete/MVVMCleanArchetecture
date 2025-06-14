package com.mvvm.clean.mvvmcleanarchitecture.data.repoImp_data

import com.mvvm.clean.mvvmcleanarchitecture.data.data_source.PhotoSizeApi
import com.mvvm.clean.mvvmcleanarchitecture.domain.model_domain.PhotoSize_domain
import com.mvvm.clean.mvvmcleanarchitecture.domain.repo_domain.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    val photoSizeApi: PhotoSizeApi
) : PhotoRepository {

    override suspend fun getPhotoSizes() = photoSizeApi.getPhotoSizes().map {
        PhotoSize_domain(
            author = it.author,
            download_url = it.download_url,
            height = it.height,
            id = it.id,
            url = it.url,
            width = it.width
        )
    }
}