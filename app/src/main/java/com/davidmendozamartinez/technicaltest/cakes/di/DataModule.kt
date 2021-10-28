package com.davidmendozamartinez.technicaltest.cakes.di

import com.davidmendozamartinez.technicaltest.cakes.data.remote.CakesService
import com.davidmendozamartinez.technicaltest.cakes.data.remote.createCakesService
import com.davidmendozamartinez.technicaltest.cakes.data.remote.source.CakeRemoteDataSource
import com.davidmendozamartinez.technicaltest.cakes.data.remote.source.CakeRemoteDataSourceImpl
import com.davidmendozamartinez.technicaltest.cakes.data.repository.CakeRepositoryImpl
import com.davidmendozamartinez.technicaltest.cakes.domain.repository.CakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideCakeRepository(remoteDataSource: CakeRemoteDataSource): CakeRepository =
        CakeRepositoryImpl(remoteDataSource)

    @Provides
    fun provideCakeRemoteDataSource(service: CakesService): CakeRemoteDataSource =
        CakeRemoteDataSourceImpl(service)

    @Singleton
    @Provides
    fun provideCakesService(): CakesService = createCakesService()
}
