package com.davidmendozamartinez.technicaltest.cakes.data.remote.source

import com.davidmendozamartinez.technicaltest.cakes.data.remote.CakesService
import com.davidmendozamartinez.technicaltest.cakes.data.remote.mapper.CakeMapper.toDomain
import com.davidmendozamartinez.technicaltest.cakes.domain.model.Cake

class CakeRemoteDataSourceImpl(private val service: CakesService) : CakeRemoteDataSource {
    override suspend fun getCakes(): List<Cake> = service.getCakes().map { it.toDomain() }
}
