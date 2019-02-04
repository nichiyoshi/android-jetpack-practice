package com.example.nichiyoshi.livedatapractice.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nichiyoshi.livedatapractice.R
import com.example.nichiyoshi.livedatapractice.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)
        binding.viewmodel = viewModel

        return binding.root
    }
}
