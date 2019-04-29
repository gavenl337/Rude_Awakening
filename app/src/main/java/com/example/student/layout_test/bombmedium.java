package com.example.student.layout_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class bombmedium extends AppCompatActivity {

    private TextView instructions;
    private TextView first_color;
    private TextView second_color;
    private TextView third_color;
    private Button redWire;
    private Button blueWire;
    private Button greenWire;
    private ImageView redWirePic;
    private ImageView greenWirePic;
    private ImageView blueWirePic;
    private boolean isRedWireCut;
    private boolean isBlueWireCut;
    private boolean isGreenWireCut;
    private int gameCase;
    private int randColor;
    private int min;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bombmedium);
        instructions = findViewById(R.id.text_instructions_medium);
        first_color = findViewById(R.id.first_color);
        second_color = findViewById(R.id.second_color);
        third_color = findViewById(R.id.third_color);
        redWire = findViewById(R.id.red_wire_medium);
        blueWire = findViewById(R.id.blue_wire_medium);
        greenWire = findViewById(R.id.green_wire_medium);
        redWirePic = findViewById(R.id.red_whole_medium);
        greenWirePic = findViewById(R.id.green_whole_medium);
        blueWirePic = findViewById(R.id.blue_whole_medium);

        isRedWireCut = false;
        isBlueWireCut = false;
        isGreenWireCut = false;
        min=1;
        max=6;
        gameCase= new Random().nextInt((max-min)+1)+min;
        randColor = new Random().nextInt((2-1)+1)+1;
        instructions.setText("Cut the wires in order");

        switch (gameCase){
            case 1: // blue green red
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.RedWords));
                    second_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    third_color.setTextColor(getResources().getColor(R.color.GreenWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    second_color.setTextColor(getResources().getColor(R.color.RedWords));
                    third_color.setTextColor(getResources().getColor(R.color.BlueWords));
                }
                first_color.setText("Blue");
                second_color.setText("Green");
                third_color.setText("Red");
                break;
            case 2: // red blue green
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
            case 3: // green red blue
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.RedWords));
                    second_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    third_color.setTextColor(getResources().getColor(R.color.GreenWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    second_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    third_color.setTextColor(getResources().getColor(R.color.RedWords));
                }
                first_color.setText("Green");
                second_color.setText("Red");
                third_color.setText("Blue");

                break;
            case 4: // red green blue
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
            case 5: // blue red green
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    second_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    third_color.setTextColor(getResources().getColor(R.color.RedWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.RedWords));
                    second_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    third_color.setTextColor(getResources().getColor(R.color.BlueWords));
                }
                first_color.setText("Blue");
                second_color.setText("Red");
                third_color.setText("Green");

                break;
            case 6: // green blue red
                if(randColor==1){
                    first_color.setTextColor(getResources().getColor(R.color.BlueWords));
                    second_color.setTextColor(getResources().getColor(R.color.RedWords));
                    third_color.setTextColor(getResources().getColor(R.color.GreenWords));
                }else if(randColor==2){
                    first_color.setTextColor(getResources().getColor(R.color.RedWords));
                    second_color.setTextColor(getResources().getColor(R.color.GreenWords));
                    third_color.setTextColor(getResources().getColor(R.color.BlueWords));
                }
                first_color.setText("Green");
                second_color.setText("Blue");
                third_color.setText("Red");

                break;
        }

        redWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRedWireCut=true;
                redWirePic.setAlpha((float) .01);
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut && isBlueWireCut && isGreenWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombmedium.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isBlueWireCut || isGreenWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isBlueWireCut || isGreenWireCut == false){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isGreenWireCut || isBlueWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isGreenWireCut || isBlueWireCut == false){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if(isRedWireCut && isBlueWireCut && isGreenWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombmedium.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });

        blueWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBlueWireCut=true;
                blueWirePic.setAlpha((float) .01);
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut || isGreenWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isGreenWireCut || isRedWireCut == false){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isGreenWireCut && isRedWireCut && isBlueWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombmedium.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isGreenWireCut && isRedWireCut && isBlueWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombmedium.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isRedWireCut || isGreenWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if (isRedWireCut || isGreenWireCut == false) {
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });

        greenWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGreenWireCut=true;
                greenWirePic.setAlpha((float) .01);
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut || isBlueWireCut == false){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isGreenWireCut && isBlueWireCut && isRedWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombmedium.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isRedWireCut || isBlueWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isRedWireCut == false || isBlueWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isGreenWireCut && isBlueWireCut && isRedWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombmedium.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if(isBlueWireCut || isRedWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombmedium.this, bombmedium.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });


    }
}
