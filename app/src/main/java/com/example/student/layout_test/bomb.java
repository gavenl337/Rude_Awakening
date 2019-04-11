package com.example.student.layout_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bomb extends AppCompatActivity {

    private TextView instructions;
    private Button redWire;
    private Button blueWire;
    private Button greenWire;
    private boolean isRedWireCut;
    private boolean isBlueWireCut;
    private boolean isGreenWireCut;
    private boolean isGameRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomb);
        instructions = findViewById(R.id.text_instructions);
        redWire = findViewById(R.id.red_wire);
        blueWire = findViewById(R.id.blue_wire);
        greenWire = findViewById(R.id.green_wire);
        isRedWireCut = false;
        isBlueWireCut = false;
        isGreenWireCut = false;
        isGameRunning = true;

        instructions.setText("cut the blue wire\n" +
                "then the green\n" +
                "and finally the red\n");

        // blue, green, red
        /* idea for randomizing instructions
        int random 1-3
        onClick{
        case int=1
        case int=2
        case int=3
        }
         */

        redWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRedWireCut=true;
                if(isBlueWireCut){
                    if(isGreenWireCut){
                        if(isRedWireCut){
                            instructions.setText("Winner");
                            Intent intent = new Intent(bomb.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }else{
                        instructions.setText("Loser");
                        Intent intent = new Intent(bomb.this, bomb.class);
                        startActivity(intent);
                    }
                }else{
                    instructions.setText("Loser");
                    Intent intent = new Intent(bomb.this, bomb.class);
                    startActivity(intent);
                }
            }
        });

        blueWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBlueWireCut=true;
                if(isRedWireCut || isGreenWireCut){
                    instructions.setText("Loser");
                    Intent intent = new Intent(bomb.this, bomb.class);
                    startActivity(intent);
                }
            }
        });

        greenWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGreenWireCut=true;
                if(isRedWireCut || !isBlueWireCut){
                    instructions.setText("Loser");
                    Intent intent = new Intent(bomb.this, bomb.class);
                    startActivity(intent);
                }
            }
        });


    }

}
