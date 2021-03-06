package com.example.student.layout_test.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.student.layout_test.MainActivity;
import com.example.student.layout_test.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                intent.setClass(Splash.this, MainActivity.class);
                Splash.this.startActivity(intent);
                Splash.this.finish();
            }
        }, 3000);
    }
}
