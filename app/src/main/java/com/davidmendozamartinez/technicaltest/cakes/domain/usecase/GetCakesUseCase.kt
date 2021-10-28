package com.davidmendozamartinez.technicaltest.cakes.domain.usecase

import com.davidmendozamartinez.technicaltest.cakes.domain.model.Cake
import com.davidmendozamartinez.technicaltest.cakes.domain.repository.CakeRepository
import javax.inject.Inject

class GetCakesUseCase @Inject constructor(private val repository: CakeRepository) {
    suspend fun invoke(): List<Cake> = repository.getCakes()
}
