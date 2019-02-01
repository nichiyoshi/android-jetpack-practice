package com.example.nichiyoshi.databindingpractice

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nichiyoshi.databindingpractice.databinding.FragmentThirdBinding

class ThirdFragment: Fragment() {

    companion object {
        fun newInstance() : ThirdFragment = ThirdFragment()
    }

    private lateinit var mBinding: FragmentThirdBinding;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_third, container, false)
        mBinding.user = User("Suguru", "Kanno", false)
        return mBinding.root
    }
}