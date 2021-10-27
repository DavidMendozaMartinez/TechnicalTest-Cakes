package com.davidmendozamartinez.technicaltest.cakes.data.remote.source

import com.davidmendozamartinez.technicaltest.cakes.domain.model.Cake

interface CakeRemoteDataSource {
    suspend fun getCakes(): List<Cake>
}
