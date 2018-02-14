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

    protected int skinColor, eyeColor, hairColor, hairStyle;
    private Paint skinPaint, eyePaint, hairPaint;
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

        skinPaint = new Paint();
        eyePaint = new Paint();
        hairPaint = new Paint();

        random = new Random();

        randomize();
    }

    public void randomize() {
        skinColor = OPAQUE + random.nextInt(MAX_COLOR + 1);
        eyeColor = OPAQUE + random.nextInt(MAX_COLOR + 1);
        hairColor = OPAQUE + random.nextInt(MAX_COLOR + 1);
        hairStyle = random.nextInt(MAX_HAIR_STYLE);

        skinPaint.setColor(skinColor);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);

        invalidate();

    }

    public void setSkinColor(int colorVal, int rgb){
        int red = Color.red(skinColor);
        int green = Color.green(skinColor);
        int blue = Color.blue(skinColor);

        switch(rgb){
            case 0: //red
                red = colorVal;
                break;
            case 1: //green
                green = colorVal;
                break;
            case 2: //blue
                blue = colorVal;
                break;

        }

        skinColor = Color.argb(0xFF,red,green,blue);
        skinPaint.setColor(skinColor);

        invalidate();
    }

    public void setEyeColor(int colorVal, int rgb){
        int red = Color.red(eyeColor);
        int green = Color.green(eyeColor);
        int blue = Color.blue(eyeColor);

        switch(rgb){
            case 0: //red
                red = colorVal;
                break;
            case 1: //green
                green = colorVal;
                break;
            case 2: //blue
                blue = colorVal;
                break;

        }

        eyeColor = Color.argb(0xFF,red,green,blue);
        eyePaint.setColor(eyeColor);

        invalidate();
    }

    public void setHairColor(int colorVal, int rgb){
        int red = Color.red(hairColor);
        int green = Color.green(hairColor);
        int blue = Color.blue(hairColor);

        switch(rgb){
            case 0: //red
                red = colorVal;
                break;
            case 1: //green
                green = colorVal;
                break;
            case 2: //blue
                blue = colorVal;
                break;

        }

        hairColor = Color.argb(0xFF,red,green,blue);
        hairPaint.setColor(hairColor);

        invalidate();
    }

    public void onDraw(Canvas c) {
        //draw face
        Paint white = new Paint();
        white.setColor(Color.WHITE);

        Paint black = new Paint();
        black.setColor(Color.BLACK);

        int xCtr = this.getWidth() / 2;
        int yCtr = this.getHeight() * 3 / 5;
        int eyeDist = 160;

        //face
        c.drawCircle(xCtr,
                yCtr,
                (this.getWidth() > this.getHeight()) ? this.getHeight() * 2 / 6 : this.getWidth() * 2 / 6,
                skinPaint);

        //eyes
        //whites
        c.drawCircle(xCtr-eyeDist,yCtr-80,80,white);
        c.drawCircle(xCtr+eyeDist,yCtr-80,80,white);

        //iris
        c.drawCircle(xCtr-eyeDist,yCtr-80,50,eyePaint);
        c.drawCircle(xCtr+eyeDist,yCtr-80,50,eyePaint);

        //mouth
        c.drawRect(xCtr-200,yCtr+190,xCtr+200,yCtr+200,black);

    }

}

