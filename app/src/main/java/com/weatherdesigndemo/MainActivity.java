package com.weatherdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_pin_mode, btn_parallex_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_pin_mode = (Button) findViewById(R.id.btn_pin_mode);
        btn_parallex_mode = (Button) findViewById(R.id.btn_parallex_mode);

        btn_parallex_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CollapseModeParallex.class));
            }
        });

        btn_pin_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CollapseModePin.class));
            }
        });
    }
}
