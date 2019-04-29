package com.example.student.layout_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class alarm extends AppCompatActivity {

    private TextView mTextMessage;
    public static final String DIFFICULTY_KEY = "DIFFICULTY_LEVEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Intent newIntent = getIntent();
        String test = newIntent.getStringExtra(DIFFICULTY_KEY);
        if (test == null || test.isEmpty()){
            test = "none";
        }
    }

}
