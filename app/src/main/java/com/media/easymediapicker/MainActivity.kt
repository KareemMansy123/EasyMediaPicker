package com.media.easymediapicker

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.media.easymediapicker.ui.theme.EasymediapickerTheme
import com.media.easymediarequester.Config
import com.media.easymediarequester.Request
import com.media.easymediarequester.RequestType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasymediapickerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Button(onClick = {
                        Request(this@MainActivity).openMedia(Config.Builder().requestType(RequestType.SingleImage).build()) {
                                Log.e("ImagePath22", "openMedia: ${it.data?.data?.path}")
                        }
                        }){
                        Text(text = "multi images")
                        }
                    }
                }
            }
        }
    }

}
