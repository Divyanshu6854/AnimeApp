package com.example.animepocapp.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.animepocapp.R

object ProgressBarHelper {
    private var progressBar: ConstraintLayout? = null

    public fun show(activity: Activity) {
        hide()
        progressBar = createProgressBar(activity)
        activity.addContentView(progressBar, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        progressBar?.visibility = ViewGroup.VISIBLE
    }

    fun show(fragment: Fragment) {
        hide()
        val activity = fragment.requireActivity()
        progressBar = createProgressBar(activity)
        activity.addContentView(progressBar, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        progressBar?.visibility = ViewGroup.VISIBLE
    }

    fun hide() {
        progressBar?.visibility = ViewGroup.GONE
        progressBar = null
    }

    private fun createProgressBar(activity: Activity): ConstraintLayout {
        return LayoutInflater.from(activity)
            .inflate(R.layout.component_dialog_progress, null) as ConstraintLayout
    }
}
