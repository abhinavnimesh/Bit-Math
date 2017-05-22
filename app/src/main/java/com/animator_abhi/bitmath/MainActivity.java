package com.animator_abhi.bitmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView im,im2;
    private Animation mAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
         im= (ImageView) findViewById(R.id.imageView);
        //im2= (ImageView) findViewById(R.id.imageView2);
       // MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
       // final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        //myAnim.setInterpolator(interpolator);

        Thread timer = new Thread() {
            public void run() {
                try {
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade1);
                im.startAnimation(animation);
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                  //  im2.setVisibility(View.VISIBLE);//bg
                    final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
//                    im.startAnimation(myAnim);
                   // im2.startAnimation(myAnim);
                    startActivity(i);
                 overridePendingTransition(R.anim.fade,R.anim.fadeout);
                }
            }
        };
      timer.start();



        /* fade anim*/
       /* mAnimation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, -1f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, -1f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.0f);
        mAnimation.setDuration(250);
        mAnimation.setRepeatCount(0);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        im.setAnimation(mAnimation);*/// fade anim on title
    }

    @Override    protected void onPause() {
        super.onPause();
        finish();

    }
}
