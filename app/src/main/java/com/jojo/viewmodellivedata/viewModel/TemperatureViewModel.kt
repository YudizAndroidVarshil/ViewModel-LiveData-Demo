package com.jojo.viewmodellivedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TemperatureViewModel : ViewModel() {

    // Private mutable LiveData for Celsius
    private val _celsius = MutableLiveData<Float>().apply { value = 0f }
    // Public immutable LiveData for Celsius
    val celsius: LiveData<Float> get() = _celsius

    // Private mutable LiveData for Fahrenheit
    private val _fahrenheit = MutableLiveData<Float>().apply { value = 32f }
    // Public immutable LiveData for Fahrenheit
    val fahrenheit: LiveData<Float> get() = _fahrenheit

    // Function to update the Celsius temperature and calculate Fahrenheit
    fun updateCelsius(newTemp: Float) {
        _celsius.value = newTemp
        _fahrenheit.value = newTemp * 9 / 5 + 32
    }
}

