package com.example.nichiyoshi.databindingpractice

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nichiyoshi.databindingpractice.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {

    companion object {
        fun newInstance() : SecondFragment = SecondFragment()
    }

    private lateinit var mBinding: FragmentSecondBinding;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_second, container, false)
        mBinding.user = User("Chikako", "Suzuki", false)
        return mBinding.root
    }

}