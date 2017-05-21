package com.animator_abhi.bitmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView im;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
         im= (ImageView) findViewById(R.id.imageView);
        Thread timer = new Thread() {
            public void run() {
                try {
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                im.startAnimation(animation);
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade,R.anim.fadeout);
                }
            }
        };
        timer.start();
    }

    @Override    protected void onPause() {
        super.onPause();
        finish();

    }
}
