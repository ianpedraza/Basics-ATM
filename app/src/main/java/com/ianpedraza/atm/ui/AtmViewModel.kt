package com.ianpedraza.atm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AtmViewModel : ViewModel() {

    private val _balance = MutableLiveData<Double>()
    val balance: LiveData<Double> = _balance

    fun deposit(amount: Double) {
        if (_balance.value == null) {
            _balance.value = amount
        } else {
            _balance.value = _balance.value!!.plus(amount)
        }
    }

    fun cash(amount: Double) {
        val mBalance = _balance.value ?: 0.0

        if (mBalance >= amount) {
            _balance.value = _balance.value!!.minus(amount)
        }
    }
}