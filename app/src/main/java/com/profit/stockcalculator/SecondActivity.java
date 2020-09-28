package com.profit.stockcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
Button trget1,trget2,trget3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        trget1 = findViewById(R.id.target1);
        trget2 = findViewById(R.id.target2);
        trget3 = findViewById(R.id.target3);
        final Boolean target1=true;
trget1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        trget1.setBackgroundColor(getResources().getColor(R.color.lightblue));
        trget2.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget3.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget1.setTextColor(getResources().getColor(R.color.colorwhite));
        trget2.setTextColor(getResources().getColor(R.color.colorBlack));
        trget3.setTextColor(getResources().getColor(R.color.colorBlack));
    }
});
trget2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        trget2.setBackgroundColor(getResources().getColor(R.color.lightblue));
        trget1.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget3.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget2.setTextColor(getResources().getColor(R.color.colorwhite));
        trget1.setTextColor(getResources().getColor(R.color.colorBlack));
        trget3.setTextColor(getResources().getColor(R.color.colorBlack));
    }
});
trget3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        trget3.setBackgroundColor(getResources().getColor(R.color.lightblue));
        trget1.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget2.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget3.setTextColor(getResources().getColor(R.color.colorwhite));
        trget2.setTextColor(getResources().getColor(R.color.colorBlack));
        trget1.setTextColor(getResources().getColor(R.color.colorBlack));
    }
});
    }
//    protected void removeBlinkingText(Button txt) {
//
//    }
//    protected void startBlinkingText(Button txt) {
//        ObjectAnimator anim = ObjectAnimator.ofInt(trget1,"backgroundColor", Color.WHITE,Color.RED,Color.WHITE);
//        anim.setDuration(800);
//        anim.setEvaluator(new ArgbEvaluator());
//        anim.setRepeatMode(ValueAnimator.REVERSE);
//        anim.setRepeatCount(Animation.INFINITE);
//        anim.start();
//
//    }
}
