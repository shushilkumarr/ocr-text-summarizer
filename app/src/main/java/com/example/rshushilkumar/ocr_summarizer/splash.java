package com.example.rshushilkumar.ocr_summarizer;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView image =findViewById(R.id.image);
        final TextView text =findViewById(R.id.name);
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(image, "scaleX", 0.7f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(image, "scaleY", 0.7f);
        scaleDownX.setDuration(1500);
        scaleDownY.setDuration(1500);

        ObjectAnimator moveUpY = ObjectAnimator.ofFloat(image, "translationY", -100);
        moveUpY.setDuration(1500);
        ObjectAnimator moveText=ObjectAnimator.ofFloat(text, "translationY", -100);
        moveText.setDuration(1500);
        AnimatorSet scaleDown = new AnimatorSet();
        AnimatorSet moveUp = new AnimatorSet();
        ValueAnimator animator = ValueAnimator.ofFloat(40, 60);
        animator.setDuration(1500);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                text.setTextSize(animatedValue);
            }
        });
        scaleDown.play(scaleDownX).with(scaleDownY);
        moveUp.play(moveUpY).before(moveText);

        scaleDown.start();
        moveUp.start();
        animator.start();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}


