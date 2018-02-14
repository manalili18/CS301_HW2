package com.example.manalili18.cs301_hw2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

    TextView redTv;
    TextView blueTv;
    TextView greenTv;

    RadioButton hair;
    RadioButton eyes;
    RadioButton skin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        face = (Face) findViewById(R.id.surfaceView);
        listener = new MyListener();

        randomBut = (Button) findViewById(R.id.button);
        randomBut.setOnClickListener(listener);

        //hairSpin = (Spinner) findViewById(R.id.spinner);
        //hairSpin.setOnItemClickListener(listener);

        redSb = (SeekBar) findViewById(R.id.red);
        redSb.setOnSeekBarChangeListener(listener);
        greenSb = (SeekBar) findViewById(R.id.green);
        greenSb.setOnSeekBarChangeListener(listener);
        blueSb = (SeekBar) findViewById(R.id.blue);
        blueSb.setOnSeekBarChangeListener(listener);

        redTv = (TextView) findViewById(R.id.redVal);
        greenTv = (TextView) findViewById(R.id.greenVal);
        blueTv = (TextView) findViewById(R.id.blueVal);

        hair = (RadioButton) findViewById(R.id.hair);
        hair.setOnClickListener(listener);
        eyes = (RadioButton) findViewById(R.id.eyes);
        eyes.setOnClickListener(listener);
        skin = (RadioButton) findViewById(R.id.skin);
        skin.setOnClickListener(listener);

    }

    //nested class so it has visibility of all the things declared above
    class MyListener implements SeekBar.OnSeekBarChangeListener, View.OnClickListener,
            Spinner.OnItemClickListener{

        public MyListener(){}

        @Override
        public void onProgressChanged(SeekBar sb, int i, boolean b) {
            switch (sb.getId()){
                case R.id.red:
                    redTv.setText(""+i);

                    if(hair.isChecked()){
                        face.setHairColor(i,0);
                    } else if(eyes.isChecked()){
                        face.setEyeColor(i,0);
                    } else if(skin.isChecked()){
                        face.setSkinColor(i,0);
                    }
                    break;

                case R.id.green:
                    greenTv.setText(""+i);

                    if(hair.isChecked()){
                        face.setHairColor(i,1);
                    } else if(eyes.isChecked()){
                        face.setEyeColor(i,1);
                    } else if(skin.isChecked()){
                        face.setSkinColor(i,1);
                    }
                    break;

                case R.id.blue:
                    blueTv.setText(""+i);

                    if(hair.isChecked()){
                        face.setHairColor(i,2);
                    } else if(eyes.isChecked()){
                        face.setEyeColor(i,2);
                    } else if(skin.isChecked()){
                        face.setSkinColor(i,2);
                    }
                    break;

                default:
                    Log.i("sb progress change", "this should never print");
                    break;
            }
        }

        @Override
        public void onStopTrackingTouch(SeekBar sb){}

        @Override
        public void onStartTrackingTouch(SeekBar sb){}

        @Override
        public void onClick(View v){
            //radio
            //button

            switch(v.getId()){
                case R.id.skin:
                    redSb.setProgress(Color.red(face.skinColor));
                    blueSb.setProgress(Color.blue(face.skinColor));
                    greenSb.setProgress(Color.green(face.skinColor));
                    break;
                case R.id.eyes:
                    redSb.setProgress(Color.red(face.eyeColor));
                    blueSb.setProgress(Color.blue(face.eyeColor));
                    greenSb.setProgress(Color.green(face.eyeColor));
                    break;
                case R.id.hair:
                    redSb.setProgress(Color.red(face.hairColor));
                    blueSb.setProgress(Color.blue(face.hairColor));
                    greenSb.setProgress(Color.green(face.hairColor));
                    break;
                case R.id.button:
                    face.randomize();
                    //TODO: update seekbars
                    break;
            }

            /*
            if(v instanceof RadioButton){
                //figure out what radio button was pressed
                //grab colors depending on radio button
                //set progress bars to color value



            } else if(v instanceof Button) {
                //randomize model
            }//*/

        }

        @Override
        public void onItemClick(AdapterView av, View v, int i, long l){

        }
    }
}


