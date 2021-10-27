package com.davidmendozamartinez.technicaltest.cakes.data.repository

import com.davidmendozamartinez.technicaltest.cakes.data.remote.source.CakeRemoteDataSource
import com.davidmendozamartinez.technicaltest.cakes.domain.model.Cake
import com.davidmendozamartinez.technicaltest.cakes.domain.repository.CakeRepository

class CakeRepositoryImpl(private val remoteDataSource: CakeRemoteDataSource): CakeRepository {
    override suspend fun getCakes(): List<Cake> = remoteDataSource.getCakes()
}
