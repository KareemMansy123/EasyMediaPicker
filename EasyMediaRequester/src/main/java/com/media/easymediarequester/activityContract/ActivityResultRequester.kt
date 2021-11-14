package com.media.easymediarequester.activityContract

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.fragment.app.FragmentActivity
import com.media.easymediarequester.activityContract.ActivityResultFrag

class ActivityResultRequester(private val activity: FragmentActivity) {

    fun request(intent: Intent, callback: (ActivityResult) -> Unit) {
        ActivityResultFrag.request(intent, activity, callback)
    }
}