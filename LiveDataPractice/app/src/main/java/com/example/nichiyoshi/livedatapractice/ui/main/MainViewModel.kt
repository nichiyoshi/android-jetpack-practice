package com.example.nichiyoshi.livedatapractice.ui.main

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.adapters.TextViewBindingAdapter

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

    init {
        sumNumber.addSource(firstNumber){
            sumNumber.value = (it?:0) + (secondNumber.value?:0)
        }

        sumNumber.addSource(secondNumber){
            sumNumber.value = (firstNumber.value?:0) + (it?:0)
        }
    }

    val onFirstTextChanged = TextViewBindingAdapter.OnTextChanged { s, _, _, _ ->
            updateFirstNumber(s.toString().toInt())
        }

    val onSecondTextChanged = TextViewBindingAdapter.OnTextChanged { s, _, _, _ ->
        updateSecondNumber(s.toString().toInt())
    }

    private fun updateFirstNumber(num: Int){
        firstNumber.postValue(num)
    }

    private fun updateSecondNumber(num: Int){
        secondNumber.postValue(num)
    }
}
