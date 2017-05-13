package com.example.siddharth.divinity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeVideoPlay extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_video_play);
        Intent i=getIntent();
        String YoutubeUrl=i.getStringExtra("VideoUrl");
        String title=i.getStringExtra("Title");
        final String[] url=YoutubeUrl.split("=");

        TextView videohead= (TextView) findViewById(R.id.aartihead);
        videohead.setText(title);
        //Toast.makeText(getApplicationContext(),url[1],Toast.LENGTH_LONG).show();
        YouTubePlayerView youTubePlayerView= (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(config.TopDeveloper_YOUTUBE_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
              youTubePlayer.loadVideo(url[1]);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

    }
}
