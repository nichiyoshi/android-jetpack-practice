package com.example.nichiyoshi.databindingpractice

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.nichiyoshi.databindingpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val user = User("Taro", "Tanaka", true)
        binding.user = user
        binding.listener = this
    }

    override fun onClick(view: View?) {
        if(view == binding.button){
            (view as Button).let{
                it.text = "clicked!!!"
            }
        }
    }
}
