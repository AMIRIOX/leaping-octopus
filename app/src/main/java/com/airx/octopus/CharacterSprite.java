package com.airx.octopus;

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
    private boolean is_updated = false;
    private int xoi;
    private int yoi;

    public void change_xy_oi(int a, int b) {
        xoi=a;
        yoi=b;
        is_updated=true;
    }
    public CharacterSprite(Bitmap bmp) {
        image = bmp;
        y = 100;
        x = 100;
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }
    public void pro_upgrade() {
        if(is_updated){
            x=xoi;
            y=yoi;
        }
        is_updated=false;
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
