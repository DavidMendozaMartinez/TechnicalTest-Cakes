package com.davidmendozamartinez.technicaltest.cakes.ui.screen.cakes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidmendozamartinez.technicaltest.cakes.domain.model.Cake
import com.davidmendozamartinez.technicaltest.cakes.domain.usecase.GetCakesUseCase
import com.davidmendozamartinez.technicaltest.cakes.ui.screen.cakes.CakesViewModel.State.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CakesViewModel @Inject constructor(private val useCase: GetCakesUseCase) : ViewModel() {

    private val _state = MutableStateFlow(LOADING)
    val isLoadingVisible: Flow<Boolean> = _state.map { it == LOADING }
    val isErrorVisible: Flow<Boolean> = _state.map { it == ERROR }

    private val _cakes = MutableStateFlow<List<Cake>>(emptyList())
    val cakes: StateFlow<List<Cake>> get() = _cakes

    init {
        getCakes()
    }

    fun onRefreshTriggered() {
        getCakes()
    }

    private fun getCakes() {
        _state.value = LOADING

        viewModelScope.launch {
            try {
                _cakes.value = useCase.invoke()
                _state.value = SUCCESS
            } catch (throwable: Throwable) {
                _state.value = ERROR
            }
        }
    }

    enum class State { LOADING, SUCCESS, ERROR }
}
