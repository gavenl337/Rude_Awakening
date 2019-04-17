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
    ToggleButton hard;
    ToggleButton extraHard;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(settings.this, alarm.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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
                }
                if (buttonView == medium) {
                    easy.setChecked(false);
                    hard.setChecked(false);
                    extraHard.setChecked(false);
                }
                if (buttonView == hard) {
                    medium.setChecked(false);
                    easy.setChecked(false);
                    extraHard.setChecked(false);
                }
                if (buttonView == extraHard) {
                    medium.setChecked(false);
                    hard.setChecked(false);
                    easy.setChecked(false);
                }
            }
        }
    };
}
