package com.example.nichiyoshi.databindingpractice

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.nichiyoshi.databindingpractice.databinding.FragmentThirdBinding

class ThirdFragment: Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() : ThirdFragment = ThirdFragment()
    }

    private lateinit var mBinding: FragmentThirdBinding;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_third, container, false)
        mBinding.user = User("Suguru", "Kanno", false)
        mBinding.listener = this
        return mBinding.root
    }

    override fun onClick(view: View?) {
        if(view == mBinding.buttonToFourthActivity){
            (view as Button).apply{
                val fourthActivity = Intent(activity, FourthActivity::class.java)
                startActivity(fourthActivity)
            }
        }
    }
}