package com.example.student.layout_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.graphics.Color;

public class settings extends AppCompatActivity {

    private TextView mTextMessage;

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
    }

}

/*
ToggleButton toggle = (ToggleButton) findViewById(R.id.togglebutton);
toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // The toggle is enabled
        } else {
            // The toggle is disabled
        }
    }
});


 */

/*
ToggleButton one;
ToggleButton two;
ToggleButton three;
ToggleButton four;

// Called when the activity is first created.
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);


    one = (ToggleButton) findViewById(R.id.toggleButton1);
    two = (ToggleButton) findViewById(R.id.toggleButton2);
    three = (ToggleButton) findViewById(R.id.toggleButton3);
    four = (ToggleButton) findViewById(R.id.toggleButton4);

    one.setOnCheckedChangeListener(changeChecker);
    two.setOnCheckedChangeListener(changeChecker);
    three.setOnCheckedChangeListener(changeChecker);
    four.setOnCheckedChangeListener(changeChecker);
}

    OnCheckedChangeListener changeChecker = new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                if (buttonView == one) {
                    two.setChecked(false);
                    three.setChecked(false);
                    four.setChecked(false);
                }
                if (buttonView == two) {
                    one.setChecked(false);
                    three.setChecked(false);
                    four.setChecked(false);
                }
                if (buttonView == three) {
                    two.setChecked(false);
                    one.setChecked(false);
                    four.setChecked(false);
                }
                if (buttonView == four) {
                    two.setChecked(false);
                    three.setChecked(false);
                    one.setChecked(false);
                }
            }
        }
    };
}

 */
