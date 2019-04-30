package com.example.student.layout_test;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;

import java.util.Random;

public class bomb extends AppCompatActivity {

    private TextView color_order;
    private Button redWire;
    private Button blueWire;
    private Button greenWire;
    private boolean isRedWireCut;
    private boolean isBlueWireCut;
    private boolean isGreenWireCut;
    private int gameCase;
    private int min;
    private int max;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private int currentVolume;
    private static final String VOLUME_KEY = "VOLUME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomb);

        mediaPlayer = MediaPlayer.create(bomb.this, R.raw.easy);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_ALARM);

        if(getIntent().getExtras() != null) {
            int newVolume = getIntent().getIntExtra(VOLUME_KEY, -1);
            if(currentVolume < newVolume) {
                for(int i = 0; i < (newVolume - currentVolume); i++) {
                    audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                }
                currentVolume = newVolume;
            }
        }

        color_order = findViewById(R.id.text_color_order);
        redWire = findViewById(R.id.red_wire);
        blueWire = findViewById(R.id.blue_wire);
        greenWire = findViewById(R.id.green_wire);
        isRedWireCut = false;
        isBlueWireCut = false;
        isGreenWireCut = false;
        min=1;
        max=6;
        gameCase= new Random().nextInt((max-min)+1)+min;


        switch (gameCase){
            case 1: // blue green red
                color_order.setText("Blue\n" +
                        "Green\n" +
                        "Red\n");
                break;
            case 2: // red blue green
                color_order.setText("Red\n" +
                        "Blue\n" +
                        "Green\n");
                break;
            case 3: // green red blue
                color_order.setText("Green\n" +
                        "Red\n" +
                        "Blue\n");
                break;
            case 4: // red green blue
                color_order.setText("Red\n" +
                        "Green\n" +
                        "Blue\n");
                break;
            case 5: // blue red green
                color_order.setText("Blue\n" +
                        "Red\n" +
                        "Green\n");
                break;
            case 6: // green blue red
                color_order.setText("Green\n" +
                        "Blue\n" +
                        "Red\n");
                break;
        }




        redWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRedWireCut=true;
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut && isBlueWireCut && isGreenWireCut){
                            evaluateGameCondition(true);
                        }else{
                            evaluateGameCondition(false);
                        }
                        break;
                    case 2: // red blue green
                        if(isBlueWireCut || isGreenWireCut){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 3: // green red blue
                        if(isBlueWireCut || isGreenWireCut == false){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 4: // red green blue
                        if(isGreenWireCut || isBlueWireCut){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 5: // blue red green
                        if(isGreenWireCut || isBlueWireCut == false){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 6: // green blue red
                        if(isRedWireCut && isBlueWireCut && isGreenWireCut){
                            evaluateGameCondition(true);
                        }else{
                            evaluateGameCondition(false);
                        }
                        break;
                }
            }
        });

        blueWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBlueWireCut=true;
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut || isGreenWireCut){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 2: // red blue green
                        if(isGreenWireCut || isRedWireCut == false){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 3: // green red blue
                        if(isGreenWireCut && isRedWireCut && isBlueWireCut){
                            evaluateGameCondition(true);
                        }else{
                            evaluateGameCondition(false);
                        }
                        break;
                    case 4: // red green blue
                        if(isGreenWireCut && isRedWireCut && isBlueWireCut){
                            evaluateGameCondition(false);
                        }else{
                            evaluateGameCondition(false);
                        }
                        break;
                    case 5: // blue red green
                        if(isRedWireCut || isGreenWireCut){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 6: // green blue red
                        if (isRedWireCut || isGreenWireCut == false) {
                            evaluateGameCondition(false);
                        }
                        break;
                }
            }
        });

        greenWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGreenWireCut=true;
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut || isBlueWireCut == false){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 2: // red blue green
                        if(isGreenWireCut && isBlueWireCut && isRedWireCut){
                            evaluateGameCondition(true);
                        }else{
                            evaluateGameCondition(false);
                        }
                        break;
                    case 3: // green red blue
                        if(isRedWireCut || isBlueWireCut){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 4: // red green blue
                        if(isRedWireCut == false || isBlueWireCut){
                            evaluateGameCondition(false);
                        }
                        break;
                    case 5: // blue red green
                        if(isGreenWireCut && isBlueWireCut && isRedWireCut){
                            evaluateGameCondition(true);
                        }else{
                            evaluateGameCondition(false);
                        }
                        break;
                    case 6: // green blue red
                        if(isBlueWireCut || isRedWireCut){
                            evaluateGameCondition(false);
                        }
                        break;
                }
            }
        });


    }
    private void evaluateGameCondition (Boolean isWin) {
        Intent intent;

        if(isWin) {
            color_order.setText("Winner");
            intent = new Intent(bomb.this, MainActivity.class);
        }
        else {
            color_order.setText("Loser");
            int newVolume = currentVolume;
            newVolume++;
            intent = new Intent(bomb.this, bomb.class);
            intent.putExtra(VOLUME_KEY, newVolume);
        }

        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;

        startActivity(intent);
    }

}
