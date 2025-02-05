package com.example.executarvideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class ExecutaActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executa);
        //        esconde barra de status
        getSupportActionBar().hide();

//        esconde status bar e barra de navegação
        View decorView = getWindow().getDecorView();
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOpcoes);

        videoView = findViewById(R.id.videoView);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoView.start();

    }
}