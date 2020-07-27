package com.example.myfirstapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float x = event.getX();
//        float y = event.getY();
//        switch (event.getAction())
//        {
//            //触摸屏幕时刻
//            case MotionEvent.ACTION_DOWN:
//
//                break;
//            //触摸并移动时刻
//            case MotionEvent.ACTION_MOVE:
//
//                break;
//            //终止触摸时刻
//            case MotionEvent.ACTION_UP:
//
//                break;
//        }
//        Toast.makeText(MainActivity.this,"控件之外的触摸事件",Toast.LENGTH_SHORT).show();
//        return super.onTouchEvent(event);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // setContentView(R.layout.activity_main);
        setContentView(new GameView(this));
    }
}