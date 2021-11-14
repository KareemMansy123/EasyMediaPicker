package com.media.easymediarequester

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat.checkSelfPermission
import com.media.easymediarequester.activityContract.ActivityResultRequester

class Request(private val context: AppCompatActivity) {
    fun openMedia(config: Config = Config(), callback: (ActivityResult) -> Unit): (ActivityResult) -> Unit {
        if (checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                context, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA),
                401
            )
            return callback
        }
            when(config.type) {
                RequestType.Camera ->  ActivityResultRequester(context).request(Requester().requestSingleImageFromCamera()) {
                    callback(it)
                }
                RequestType.SingleImage -> ActivityResultRequester(context).request(Requester().requestSingleImageFromGallery()) {
                    callback(it)
                }
//                RequestType.MultiImages -> ActivityResultRequester(context).request(Requester().requestMultiImageFromGallery()) {
//                    callback(it)
//                }
                RequestType.RecordVideo -> ActivityResultRequester(context).request(Requester().requestRecordVideo()) {
                    callback(it)
                }
                RequestType.VideoFromGallery -> ActivityResultRequester(context).request(
                    Requester().requestSingleVideoFromGallery()) {
                    callback(it)
                }
            }

        return callback
    }
}