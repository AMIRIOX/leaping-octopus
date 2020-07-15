package com.example.myfirstapp;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import  android.view.SurfaceView;
import android.content.Context;
import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Path;
//import android.util.AttributeSet;
import android.view.SurfaceHolder;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{
    private  MainThread thread;
    private CharacterSprite characterSprite;

    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int wigth, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }
    public void update() {
        characterSprite.update();
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(canvas!=null) {
            characterSprite.draw(canvas);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        characterSprite = new CharacterSprite((BitmapFactory.decodeResource(getResources(),R.drawable.zy100x100)));
        thread.setRunning(true);
        thread.start();
    }

}
