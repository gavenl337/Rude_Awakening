package com.example.student.layout_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomb);
        color_order = findViewById(R.id.text_color_order);
        redWire = findViewById(R.id.red_wire);
        blueWire = findViewById(R.id.blue_wire);
        greenWire = findViewById(R.id.green_wire);
        isRedWireCut = false;
        isBlueWireCut = false;
        isGreenWireCut = false;
        min=1;
        max=2;
        gameCase= new Random().nextInt((max-min)+1)+min;

        switch (gameCase){
            case 1:
                color_order.setText("cut the blue wire\n" +
                        "then the green\n" +
                        "and finally the red\n");
                break;
            case 2:
                color_order.setText("cut the red wire\n" +
                        "then the blue\n" +
                        "and finally the green\n");
                break;
        }


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
                switch (gameCase){
                    case 1:
                        if(isBlueWireCut){
                            if(isGreenWireCut){
                                if(isRedWireCut){
                                    color_order.setText("Winner");
                                    Intent intent = new Intent(bomb.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }else{
                                color_order.setText("Loser");
                                Intent intent = new Intent(bomb.this, bomb.class);
                                startActivity(intent);
                            }
                        }else{
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 2:
                        if(isBlueWireCut || isGreenWireCut){
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
                switch (gameCase){
                    case 1:
                        if(isRedWireCut || isGreenWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 2:
                        if(isGreenWireCut || !isRedWireCut){
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
                switch (gameCase){
                    case 1:
                        if(isRedWireCut || !isBlueWireCut){
                            color_order.setText("Loser");
                            Intent intent = new Intent(bomb.this, bomb.class);
                            startActivity(intent);
                        }
                        break;
                    case 2:
                        if(isRedWireCut){
                            if(isBlueWireCut){
                                if(isGreenWireCut){
                                    color_order.setText("Winner");
                                    Intent intent = new Intent(bomb.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    color_order.setText("Loser");
                                    Intent intent = new Intent(bomb.this, bomb.class);
                                    startActivity(intent);
                                }
                            }else{
                                color_order.setText("Loser");
                                Intent intent = new Intent(bomb.this, bomb.class);
                                startActivity(intent);
                            }
                        }else{
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
