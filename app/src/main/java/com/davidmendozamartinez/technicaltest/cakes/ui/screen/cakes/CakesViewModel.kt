package com.davidmendozamartinez.technicaltest.cakes.ui.screen.cakes

import androidx.lifecycle.ViewModel
import com.davidmendozamartinez.technicaltest.cakes.domain.usecase.GetCakesUseCase

class CakesViewModel(private val useCase: GetCakesUseCase) : ViewModel()
