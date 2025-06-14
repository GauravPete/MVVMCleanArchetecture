package com.mvvm.clean.mvvmcleanarchitecture.data.data_source

import com.mvvm.clean.mvvmcleanarchitecture.data.model_data.PhotoSize_data
import com.mvvm.clean.mvvmcleanarchitecture.utils.Constants
import retrofit2.http.GET

interface PhotoSizeApi {
    // https://picsum.photos/v2/list
    @GET(Constants.PHOTO_SIZE_ENDPOINT)
    suspend fun getPhotoSizes(): List<PhotoSize_data>
}