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

package com.example.android.lifecycles.step3
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.os.SystemClock

import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

/**
 * A ViewModel used for the {@link ChronoActivity3}.
 */
class LiveDataTimerViewModel : ViewModel(){

    companion object {
        const val ONE_SECOND: Long = 1000
    }

    val mElapsedTime = MutableLiveData<Long>()

    private var mInitialTime: Long = SystemClock.elapsedRealtime()

    init{
        val timer = Timer()
        timer.scheduleAtFixedRate(ONE_SECOND, ONE_SECOND){
            val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
            mElapsedTime.postValue(newValue)
        }
    }
}
