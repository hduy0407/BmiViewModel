package com.example.bmiviewmodel.viewmodel
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.math.pow
import kotlin.math.round



class BmiViewmodel : ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    private var _bmi by mutableStateOf<Double?>(null)

    val bmi: Double?
        get() = _bmi

    fun calculateBMI() {
        val heightValue = height.toDoubleOrNull()
        val weightValue = weight.toDoubleOrNull()

        _bmi = if (heightValue != null && weightValue != null && heightValue > 0) {
            val result = weightValue / heightValue.pow(2)
            round(result * 10) / 10
        } else {
            null
        }
    }
}
