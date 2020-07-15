package com.example.myfirstapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterSprite {
    private Bitmap image;
    private int x,y;
    private int xv = 10;
    private int yv = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public CharacterSprite(Bitmap bmp) {
        image = bmp;
        y = 100;
        x = 100;
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update() {
        if(x < 0 && y <0) {
            x = screenWidth / 2;
            y = screenHeight / 2;
        }else {
            x += xv;
            y+=yv;
            if( (x > screenWidth - image.getWidth()) || (x < 0) ) {
                xv=xv*-1;
            }
            if( (y > screenHeight - image.getHeight()) || (y < 0) ) {
                yv=yv*-1;
            }
        }
    }
}
