package com.example.nichiyoshi.livedatapractice.ui.main

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val firstNumber : MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

    val secondNumber : MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

    val sumNumber : MediatorLiveData<Int> by lazy{
        MediatorLiveData<Int>()
    }

    val dummyInt : Int = 100

    init {
        sumNumber.addSource(firstNumber){
            sumNumber.value = it?:0 + (secondNumber.value?:0)
        }

        sumNumber.addSource(secondNumber){
            sumNumber.value = firstNumber.value?:0 + (it?:0)
        }
    }

    fun updateFirstNumber(num: Int){
        firstNumber.postValue(num)
    }

    fun updateSecondNumber(num: Int){
        secondNumber.postValue(num)
    }
}
