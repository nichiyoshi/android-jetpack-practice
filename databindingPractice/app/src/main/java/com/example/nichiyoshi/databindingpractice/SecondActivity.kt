package com.example.nichiyoshi.databindingpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second);
        if(savedInstanceState == null){
            val secondFragment = SecondFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, secondFragment).commit()
        }
    }

}