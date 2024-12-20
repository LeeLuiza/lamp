package com.example.lamp.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lamp.domain.SetBrightnessLevelUseCase
import com.example.lamp.domain.SetColorUseCase
import com.example.lamp.domain.TurnOffUseCase
import com.example.lamp.domain.TurnOnUseCase
import com.example.lamp.UiState
import com.example.lamp.domain.GetColorUseCase
import com.example.lamp.toUiState
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MainFragmentViewModel  @Inject constructor(
    private val turnOnUseCase: TurnOnUseCase,
    private val turnOffUseCase: TurnOffUseCase,
    private val getColorsUseCase: GetColorUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val setBrightnessLevelUseCase: SetBrightnessLevelUseCase
) : ViewModel() {

    private val _lampState = MutableLiveData<UiState<Boolean>>()
    val lampState: LiveData<UiState<Boolean>> = _lampState

    private val _stateTurnOff = MutableLiveData<UiState<Boolean>>()
    val stateTurnOff: LiveData<UiState<Boolean>> = _stateTurnOff

    private val _stateBrightness = MutableLiveData<UiState<Boolean>>()
    val stateBrightness: LiveData<UiState<Boolean>> = _stateBrightness

    private val _colors = MutableLiveData<UiState<List<String>>>()
    val colors: LiveData<UiState<List<String>>> = _colors

    private val _stateColor = MutableLiveData<UiState<Boolean>>()
    val stateColor: LiveData<UiState<Boolean>> = _stateColor

    fun turnOn(){
        viewModelScope.launch {
            _lampState.value = UiState.Loading
            val result = runCatching { turnOnUseCase() }
            _lampState.value = result.toUiState()
        }
    }

    fun turnOff(){
        viewModelScope.launch {
            _stateTurnOff.value = UiState.Loading
            val result = runCatching { turnOffUseCase() }
            _stateTurnOff.value = result.toUiState()
        }
    }

    fun setBrightness(level: Int){
        viewModelScope.launch {
            _stateBrightness.value = UiState.Loading
            val result = runCatching { setBrightnessLevelUseCase(level) }
            _stateBrightness.value = result.toUiState()
        }
    }

    fun getColors(){
        viewModelScope.launch {
            _colors.value = UiState.Loading
            val result = runCatching { getColorsUseCase() }
            _colors.value = result.toUiState()
        }
    }

    fun setColor(color: String){
        viewModelScope.launch {
            _stateColor.value = UiState.Loading
            val result = runCatching { setColorUseCase(color) }
            _stateColor.value = result.toUiState()
        }
    }
}