package com.example.nichiyoshi.databindingpractice

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.nichiyoshi.databindingpractice.databinding.FragmentSecondBinding

class SecondFragment: Fragment(),  View.OnClickListener {

    companion object {
        fun newInstance() : SecondFragment = SecondFragment()
    }

    private lateinit var mBinding: FragmentSecondBinding;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_second, container, false)
        mBinding.user = User("Chikako", "Suzuki", false)
        mBinding.listener = this
        return mBinding.root
    }

    override fun onClick(view: View?) {
        if(view == mBinding.buttonToThirdActivity){
            (view as Button).let{
                val intentToThirdActivity = Intent(activity, ThirdActivity::class.java)
                startActivity(intentToThirdActivity)
            }
        }
    }

}