package com.example.nichiyoshi.databindingpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third);
        if(savedInstanceState == null){
            val thirdFragment = ThirdFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, thirdFragment).commit()
        }
    }

}