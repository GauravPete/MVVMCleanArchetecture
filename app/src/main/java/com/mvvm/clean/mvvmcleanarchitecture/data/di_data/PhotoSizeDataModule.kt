package com.mvvm.clean.mvvmcleanarchitecture.data.di_data

import com.mvvm.clean.mvvmcleanarchitecture.data.data_source.PhotoSizeApi
import com.mvvm.clean.mvvmcleanarchitecture.data.repoImp_data.PhotoRepositoryImpl
import com.mvvm.clean.mvvmcleanarchitecture.domain.repo_domain.PhotoRepository
import com.mvvm.clean.mvvmcleanarchitecture.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PhotoSizeDataModule {

    @Provides
    @Singleton
    fun providePhotoSizeApi(): PhotoSizeApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoSizeApi::class.java)
    }

    @Provides
    @Singleton
    fun providePhotoRepository(photoApi: PhotoSizeApi): PhotoRepository {
        return PhotoRepositoryImpl(photoApi)
    }
}