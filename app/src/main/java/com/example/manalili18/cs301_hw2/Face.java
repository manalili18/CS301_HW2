package com.example.manalili18.cs301_hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by manalili18 on 2/8/2018.
 */

public class Face extends SurfaceView {

    private final int NUM_SKIN = 0;
    private final int NUM_EYE = 0;
    private final int NUM_HAIR_COLOR = 0;
    private final int NUM_HAIR_STYLE = 0;

    private int skinColor, eyeColor, hairColor, hairStyle;
    public static Random random;

    public Face(Context context) {
        super(context);
        ctorInit();
    }

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctorInit();
    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ctorInit();
    }

    public void ctorInit() {

        this.setWillNotDraw(false);

        // TODO: format citation
        // https://stackoverflow.com/questions/6202818/initializing-multiple-variables-to-the-same-value-in-java
        skinColor = eyeColor = hairColor = hairStyle = 0; // stack overflow

        random = new Random();

        randomize();
    }

    public void randomize() {
        skinColor = random.nextInt(NUM_SKIN-1);
        eyeColor = random.nextInt(NUM_EYE-1);
        hairColor = random.nextInt(NUM_HAIR_COLOR-1);
        hairStyle = random.nextInt(NUM_HAIR_STYLE-1);
    }

    public void onDraw(Canvas c) {
        //draw face
    }
}
