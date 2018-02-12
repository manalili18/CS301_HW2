package com.example.manalili18.cs301_hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by manalili18 on 2/8/2018.
 */

public class Face extends SurfaceView {

    private final static int OPAQUE = 0xFF000000;
    private final static int MAX_COLOR = 0x00FFFFFF;
    private final static int MAX_HAIR_STYLE = HAIR_STYLE.values().length;

    // TODO: format citation
    // http://www.javapractices.com/topic/TopicAction.do?Id=1
    private enum HAIR_STYLE {
        BALD,
        AFRO,
        MOHAWK
    }

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
        skinColor = OPAQUE + random.nextInt(MAX_COLOR+1); // TODO: consider putting bounds on this
        eyeColor = OPAQUE + random.nextInt(MAX_COLOR+1);
        hairColor = OPAQUE + random.nextInt(MAX_COLOR+1);
        hairStyle = random.nextInt(MAX_HAIR_STYLE);
    }

    public void onDraw(Canvas c) {
        //draw face
        Paint temp = new Paint();
        temp.setColor(Color.BLUE);
        c.drawCircle(this.getWidth()/2,this.getHeight()/2,20,temp);
    }
}
