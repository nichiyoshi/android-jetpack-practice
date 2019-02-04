package com.example.nichiyoshi.lifecycleawarevideodemo.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import com.example.nichiyoshi.lifecycleawarevideodemo.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        const val videoPath = "android.resource://" + "com.example.nichiyoshi.lifecycleawarevideodemo" + "/" + R.raw.atoms_video
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(this::class.simpleName, "onCreateView")
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videoView = view.findViewById(R.id.video_view)
        videoView.setVideoPath(videoPath)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        videoView.setOnPreparedListener {
            it.isLooping = true
            it.seekTo(viewModel.startTime)
            it.start()
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.startTime = videoView.currentPosition
        videoView.stopPlayback()
    }

}
