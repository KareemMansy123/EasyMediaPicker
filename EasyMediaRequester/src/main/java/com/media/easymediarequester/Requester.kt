package com.media.easymediarequester

import android.content.Intent
import android.provider.MediaStore

class Requester {
    fun requestSingleImageFromGallery() : Intent {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        return intent
    }
    fun requestSingleImageFromCamera() : Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    fun requestSingleVideoFromGallery() : Intent  {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT,false)
        intent.type = "video/*"
        return intent
    }
    fun requestRecordVideo() : Intent {
        val recordVideoIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        recordVideoIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 30)
        recordVideoIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1)
        return recordVideoIntent
    }
    fun requestMultiImageFromGallery() : Intent {
        val intent = Intent()
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.action = Intent.ACTION_GET_CONTENT
        intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        return intent
    }
}