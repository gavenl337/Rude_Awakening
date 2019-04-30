package com.example.student.layout_test;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import java.util.Random;

public class bombhard extends AppCompatActivity {

    private TextView instructions;
    private TextView first_color;
    private TextView second_color;
    private TextView third_color;
    private Button redWire;
    private Button blueWire;
    private Button greenWire;
    private boolean isRedWireCut;
    private boolean isBlueWireCut;
    private boolean isGreenWireCut;
    private int gameCase;
    private int randColor;
    private int min;
    private int max;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private int currentVolume;
    private static final String VOLUME_KEY = "VOLUME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bombhard);

        mediaPlayer = MediaPlayer.create(bombhard.this, R.raw.hard);
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

        instructions = findViewById(R.id.text_instructions_hard);
        first_color = findViewById(R.id.first_color_hard);
        second_color = findViewById(R.id.second_color_hard);
        third_color = findViewById(R.id.third_color_hard);
        redWire = findViewById(R.id.red_wire_hard);
        blueWire = findViewById(R.id.blue_wire_hard);
        greenWire = findViewById(R.id.green_wire_hard);
        isRedWireCut = false;
        isBlueWireCut = false;
        isGreenWireCut = false;
        min=1;
        max=6;
        gameCase= new Random().nextInt((max-min)+1)+min;
        randColor = new Random().nextInt((2-1)+1)+1;

        switch (gameCase){
            case 1: // blue green red
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.RedWords));
                    second_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    third_color.setTextColor(getResources().getColor(R.color.BlueWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    second_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    third_color.setTextColor(getResources().getColor(R.color.RedWords));
                }
                first_color.setText("Blue");
                second_color.setText("Red");
                third_color.setText("Green");
                break;
            case 2: // red blue green
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    second_color.setTextColor(getResources().getColor(R.color.RedWords));
                    third_color.setTextColor(getResources().getColor(R.color.GreenWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    second_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    third_color.setTextColor(getResources().getColor(R.color.RedWords));
                }
                first_color.setText("Red");
                second_color.setText("Green");
                third_color.setText("Blue");

                break;
            case 3: // green red blue
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.RedWords));
                    second_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    third_color.setTextColor(getResources().getColor(R.color.BlueWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    second_color.setTextColor(getResources().getColor(R.color.RedWords));
                    third_color.setTextColor(getResources().getColor(R.color.GreenWords));
                }
                first_color.setText("Green");
                second_color.setText("Blue");
                third_color.setText("Red");

                break;
            case 4: // red green blue
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    second_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    third_color.setTextColor(getResources().getColor(R.color.RedWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    second_color.setTextColor(getResources().getColor(R.color.RedWords));
                    third_color.setTextColor(getResources().getColor(R.color.BlueWords));
                }
                first_color.setText("Red");
                second_color.setText("Blue");
                third_color.setText("Green");

                break;
            case 5: // blue red green
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    second_color.setTextColor(getResources().getColor(R.color.RedWords));
                    third_color.setTextColor(getResources().getColor(R.color.BlueWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.RedWords));
                    second_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    third_color.setTextColor(getResources().getColor(R.color.GreenWords));
                }
                first_color.setText("Blue");
                second_color.setText("Green");
                third_color.setText("Red");

                break;
            case 6: // green blue red
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    second_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    third_color.setTextColor(getResources().getColor(R.color.RedWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.RedWords));
                    second_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    third_color.setTextColor(getResources().getColor(R.color.GreenWords));
                }
                first_color.setText("Green");
                second_color.setText("Red");
                third_color.setText("Blue");

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
                            evaluateGameCondition(true);
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
            instructions.setText("Winner");
            intent = new Intent(bombhard.this, MainActivity.class);
        }
        else {
            instructions.setText("Loser");
            int newVolume = currentVolume;
            newVolume++;
            intent = new Intent(bombhard.this, bombhard.class);
            intent.putExtra(VOLUME_KEY, newVolume);
        }

        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;

        startActivity(intent);
    }
}
