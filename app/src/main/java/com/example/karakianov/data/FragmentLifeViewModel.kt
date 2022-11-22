package com.example.karakianov.data

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.karakianov.MainActivity

class FragmentLifeViewModel : DefaultLifecycleObserver {
    private var isResumed = false
    var activity:MainActivity?=null

    override fun onResume(owner: LifecycleOwner) {
        activity?.directionRight()
        isResumed = true
    }

    override fun onPause(owner: LifecycleOwner) {
        isResumed = false
    }
}