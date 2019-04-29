package com.example.student.layout_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import java.util.Random;

public class bombfuck extends AppCompatActivity {

    private TextView instructions;
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
    private int min;
    private int max;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bombfuck);

        instructions = findViewById(R.id.text_instructions_fuck);
        redWire = findViewById(R.id.red_wire_fuck);
        blueWire = findViewById(R.id.blue_wire_fuck);
        greenWire = findViewById(R.id.green_wire_fuck);
        redWirePic = findViewById(R.id.red_whole_fuck);
        greenWirePic = findViewById(R.id.green_whole_fuck);
        blueWirePic = findViewById(R.id.blue_whole_fuck);
        isRedWireCut = false;
        isBlueWireCut = false;
        isGreenWireCut = false;
        min=1;
        max=6;
        gameCase= new Random().nextInt((max-min)+1)+min;
        //instructions.setText("Good Luck!");


        redWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRedWireCut=true;
                redWirePic.setAlpha((float) .01);
                switch (gameCase){
                    case 1: // blue green red
                        if(isRedWireCut && isBlueWireCut && isGreenWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombfuck.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isBlueWireCut || isGreenWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isBlueWireCut || isGreenWireCut == false){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isGreenWireCut || isBlueWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isGreenWireCut || isBlueWireCut == false){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if(isRedWireCut && isBlueWireCut && isGreenWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombfuck.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
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
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isGreenWireCut || isRedWireCut == false){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isGreenWireCut && isRedWireCut && isBlueWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombfuck.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isGreenWireCut && isRedWireCut && isBlueWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombfuck.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isRedWireCut || isGreenWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if (isRedWireCut || isGreenWireCut == false) {
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
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
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 2: // red blue green
                        if(isGreenWireCut && isBlueWireCut && isRedWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombfuck.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 3: // green red blue
                        if(isRedWireCut || isBlueWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 4: // red green blue
                        if(isRedWireCut == false || isBlueWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 5: // blue red green
                        if(isGreenWireCut && isBlueWireCut && isRedWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bombfuck.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                    case 6: // green blue red
                        if(isBlueWireCut || isRedWireCut){
                            instructions.setText("Loser");
                            Intent intent = new Intent(bombfuck.this, bombfuck.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });


    }

}