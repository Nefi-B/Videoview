package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity(){
var videoView:VideoView?=null
var mediaController:MediaController?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById<View>(R.id.videoView) as VideoView?

        if (mediaController == null) {
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.videoView)

        }
        videoView!!.setMediaController(mediaController)
        videoView!!.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.video1))

        videoView!!.requestFocus()
        videoView!!.start()
        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext,"video ",Toast.LENGTH_LONG).show()
        }
            videoView!!.setOnErrorListener{
            mediaplayer,i,i2->
            Toast.makeText(applicationContext,"Error Occured",Toast.LENGTH_LONG).show()
            false
        }
    }
}
