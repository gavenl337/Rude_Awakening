package com.example.student.layout_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class bomb extends AppCompatActivity {

    private TextView color_order;
    private Button redWire;
    private Button blueWire;
    private Button greenWire;
    private ImageView fullRedWire;
    private ImageView fullBlueWire;
    private ImageView fullGreenWire;
    private boolean isRedWireCut;
    private boolean isBlueWireCut;
    private boolean isGreenWireCut;
    private int gameCase;
    private int min;
    private int max;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomb);
        color_order = findViewById(R.id.text_color_order);
        redWire = findViewById(R.id.red_wire);
        blueWire = findViewById(R.id.blue_wire);
        greenWire = findViewById(R.id.green_wire);
        fullRedWire = findViewById(R.id.full_Red_wire_easy);
        fullBlueWire = findViewById(R.id.full_Blue_wire_easy);
        fullGreenWire = findViewById(R.id.full_Green_wire_easy);
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
                fullRedWire.setVisibility(View.INVISIBLE);
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut && isBlueWireCut && isGreenWireCut){
                            color_order.setText("Winner");
                            Intent intent = new Intent(bomb.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isBlueWireCut || isGreenWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isBlueWireCut || isGreenWireCut == false){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isGreenWireCut || isBlueWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isGreenWireCut || isBlueWireCut == false){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if(isRedWireCut && isBlueWireCut && isGreenWireCut){
                            color_order.setText("Winner");
                            Intent intent = new Intent(bomb.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
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
                fullBlueWire.setVisibility(View.INVISIBLE);
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut || isGreenWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isGreenWireCut || isRedWireCut == false){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isGreenWireCut && isRedWireCut && isBlueWireCut){
                            color_order.setText("Winner");
                            Intent intent = new Intent(bomb.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isGreenWireCut && isRedWireCut && isBlueWireCut){
                            color_order.setText("Winner");
                            Intent intent = new Intent(bomb.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isRedWireCut || isGreenWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if (isRedWireCut || isGreenWireCut == false) {
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
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
                fullGreenWire.setVisibility(View.INVISIBLE);
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut || isBlueWireCut == false){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isGreenWireCut && isBlueWireCut && isRedWireCut){
                            color_order.setText("Winner");
                            Intent intent = new Intent(bomb.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isRedWireCut || isBlueWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isRedWireCut == false || isBlueWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isGreenWireCut && isBlueWireCut && isRedWireCut){
                            color_order.setText("Winner");
                            Intent intent = new Intent(bomb.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if(isBlueWireCut || isRedWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });


    }

}
