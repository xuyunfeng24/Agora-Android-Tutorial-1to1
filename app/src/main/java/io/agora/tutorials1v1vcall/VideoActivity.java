package io.agora.tutorials1v1vcall;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        /**
         * VideoView控制视频播放的功能相对较少，具体而言，它只有start和pause方法。为了提供更多的控制，
         * 可以实例化一个MediaController，并通过setMediaController方法把它设置为VideoView的控制器。
         */
        videoView.setMediaController(new MediaController(this));
        Uri videoUri = Uri.parse(getIntent().getStringExtra("path"));
        videoView.setVideoURI(videoUri);
        videoView.start();
    }
}
