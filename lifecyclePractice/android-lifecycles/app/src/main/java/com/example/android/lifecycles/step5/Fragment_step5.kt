/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.step5;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProviders

import com.example.android.codelabs.lifecycle.R;
import java.util.Observer

/**
 * Shows a SeekBar that should be synced with a value in a ViewModel.
 */

class Fragment_step5 : Fragment(), SeekBar.OnSeekBarChangeListener{

    private lateinit var mSeekBar : SeekBar
    private lateinit var mSeekBarViewModel: SeekBarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_step5, container, false)
        mSeekBar = root.findViewById(R.id.seekBar)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mSeekBarViewModel = ViewModelProviders.of(activity as AppCompatActivity).get(SeekBarViewModel::class.java)
        subscribeSeekBar()
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        if(!p2) return
        mSeekBarViewModel.seekbarValue.postValue(p1)
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {}

    override fun onStopTrackingTouch(p0: SeekBar?) {}

    private fun subscribeSeekBar(){
        mSeekBar.setOnSeekBarChangeListener(this)
        mSeekBarViewModel.seekbarValue.observe(activity as AppCompatActivity, androidx.lifecycle.Observer{
            mSeekBar.progress = it
        })
    }

}

//public class Fragment_step5 extends Fragment {
//
//    private SeekBar mSeekBar;
//
//    private SeekBarViewModel mSeekBarViewModel;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View root = inflater.inflate(R.layout.fragment_step5, container, false);
//        mSeekBar = root.findViewById(R.id.seekBar);
//
//        // TODO: get ViewModel
//        subscribeSeekBar();
//
//        return root;
//    }
//
//    private void subscribeSeekBar() {
//
//        // Update the ViewModel when the SeekBar is changed.
//
//        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                // TODO: Set the ViewModel's value when the change comes from the user.
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) { }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) { }
//        });
//
//        // TODO: Update the SeekBar when the ViewModel is changed.
//        // mSeekBarViewModel.seekbarValue.observe(...
//    }
//}
