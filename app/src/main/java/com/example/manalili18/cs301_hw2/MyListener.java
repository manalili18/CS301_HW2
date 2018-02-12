package com.example.manalili18.cs301_hw2;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by manalili18 on 2/8/2018.
 */

// TODO: Spinners????????
public class MyListener implements SeekBar.OnSeekBarChangeListener, View.OnClickListener,
        Spinner.OnItemClickListener{

    ArrayList<TextView> allTVs;

    public MyListener() {
        allTVs = new ArrayList<>();
    }

    protected void addTV(TextView tv) { allTVs.add(tv); }

    @Override
    public void onProgressChanged(SeekBar sb, int i, boolean b) {

        for (TextView tv : allTVs){
            switch (sb.getId()){
                case R.id.red:
                    if(tv.getId()==R.id.redVal)
                        tv.setText(""+i);
                    break;
                case R.id.blue:
                    if(tv.getId()==R.id.blueVal)
                        tv.setText(""+i);
                    break;
                case R.id.green:
                    if(tv.getId()==R.id.greenVal)
                        tv.setText(""+i);
                    break;
                default:
                    Log.i("sb progress change", "this should never print");
                    break;
            }
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

        if(v instanceof RadioButton){
            //figure out what radio button was pressed
            //grab colors depending on radio button
            //set progress bars to color value
        } else if(v instanceof Button) {
            //randomize model
        }

    }

    @Override
    public void onItemClick(AdapterView av, View v, int i, long l){

    }


}
