package com.example.student.layout_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;


public class settings extends AppCompatActivity {

    private TextView mTextMessage;
    private ToggleButton easy;
    private ToggleButton medium;
    private ToggleButton hard;
    private ToggleButton extraHard;
    String difficultyLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mTextMessage = (TextView) findViewById(R.id.message);
        easy = (ToggleButton) findViewById(R.id.difficultyEasy);
        medium = (ToggleButton) findViewById(R.id.difficultyMedium);
        hard = (ToggleButton) findViewById(R.id.difficultyHard);
        extraHard = (ToggleButton) findViewById(R.id.difficultyExtraHard);

        easy.setOnCheckedChangeListener(changeChecker);
        medium.setOnCheckedChangeListener(changeChecker);
        hard.setOnCheckedChangeListener(changeChecker);
        extraHard.setOnCheckedChangeListener(changeChecker);


    }

    OnCheckedChangeListener changeChecker = new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                if (buttonView == easy) {
                    medium.setChecked(false);
                    hard.setChecked(false);
                    extraHard.setChecked(false);
                    difficultyLevel = "easy";
                }
                if (buttonView == medium) {
                    easy.setChecked(false);
                    hard.setChecked(false);
                    extraHard.setChecked(false);
                    difficultyLevel = "medium";
                }
                if (buttonView == hard) {
                    medium.setChecked(false);
                    easy.setChecked(false);
                    extraHard.setChecked(false);
                    difficultyLevel = "hard";
                }
                if (buttonView == extraHard) {
                    medium.setChecked(false);
                    hard.setChecked(false);
                    easy.setChecked(false);
                    difficultyLevel = "extra hard";
                }
            }
            /*
            Intent intent = new Intent(settings.this, alarm.class);
            intent.putExtra(alarm.DIFFICULTY_KEY, difficultyLevel);
            startActivity(intent);
            */
        }
    };
}
