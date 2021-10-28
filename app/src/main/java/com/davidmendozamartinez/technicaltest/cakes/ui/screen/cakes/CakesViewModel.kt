package com.davidmendozamartinez.technicaltest.cakes.ui.screen.cakes

import androidx.lifecycle.ViewModel
import com.davidmendozamartinez.technicaltest.cakes.domain.usecase.GetCakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CakesViewModel @Inject constructor(private val useCase: GetCakesUseCase) : ViewModel()
