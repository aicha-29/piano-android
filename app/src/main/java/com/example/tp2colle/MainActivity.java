package com.example.tp2colle;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupButtonWithSound(R.id.button1, R.raw.c3);
        setupButtonWithSound(R.id.button2, R.raw.d3);
        setupButtonWithSound(R.id.button3, R.raw.e3);
        setupButtonWithSound(R.id.button4, R.raw.f3);
        setupButtonWithSound(R.id.button5, R.raw.a3);
        setupButtonWithSound(R.id.button6, R.raw.g3);
        setupButtonWithSound(R.id.button7, R.raw.b3);
        setupButtonWithSound(R.id.button8, R.raw.c3);
        setupButtonWithSound(R.id.button9, R.raw.d3);
        setupButtonWithSound(R.id.button10, R.raw.e3);
        setupButtonWithSound(R.id.button11, R.raw.f3);
        setupButtonWithSound(R.id.button12, R.raw.a3);
        setupButtonWithSound(R.id.button13, R.raw.g3);
    }


    private void setupButtonWithSound(int buttonId, int soundId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(view -> playSound(soundId));
    }


    private void playSound(int soundId) {
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(this, soundId);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(mp -> releaseMediaPlayer());
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }
}