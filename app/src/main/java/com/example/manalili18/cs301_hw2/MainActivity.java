package com.example.manalili18.cs301_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Face face;
    MyListener listener;

    Button randomBut;
    Spinner hairSpin;

    SeekBar redSb;
    SeekBar greenSb;
    SeekBar blueSb;

    RadioButton hair;
    RadioButton eyes;
    RadioButton skin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        face = (Face) findViewById(R.id.surfaceView);
        listener = new MyListener();
/*
        randomBut = (Button) findViewById(R.id.button);
        randomBut.setOnClickListener(listener);
*/


        listener.addTV((TextView)findViewById(R.id.redVal));
        listener.addTV((TextView)findViewById(R.id.greenVal));
        listener.addTV((TextView)findViewById(R.id.blueVal));


/*
        hairSpin = (Spinner) findViewById(R.id.spinner);
        hairSpin.setOnItemClickListener(listener);
*/
        redSb = (SeekBar) findViewById(R.id.red);
        redSb.setOnSeekBarChangeListener(listener);
        greenSb = (SeekBar) findViewById(R.id.green);
        greenSb.setOnSeekBarChangeListener(listener);
        blueSb = (SeekBar) findViewById(R.id.blue);
        blueSb.setOnSeekBarChangeListener(listener);

        /*
        hair = (RadioButton) findViewById(R.id.hair);
        hair.setOnClickListener(listener);
        eyes = (RadioButton) findViewById(R.id.eyes);
        eyes.setOnClickListener(listener);
        skin = (RadioButton) findViewById(R.id.skin);
        skin.setOnClickListener(listener);
        */

    }
}
