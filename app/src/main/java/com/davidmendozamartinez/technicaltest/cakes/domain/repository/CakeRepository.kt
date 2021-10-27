package com.davidmendozamartinez.technicaltest.cakes.domain.repository

import com.davidmendozamartinez.technicaltest.cakes.domain.model.Cake

interface CakeRepository {
    suspend fun getCakes(): List<Cake>
}
