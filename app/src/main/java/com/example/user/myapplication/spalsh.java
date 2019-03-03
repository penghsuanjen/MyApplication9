package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class spalsh extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
       tv = (TextView)this.findViewById(R.id.tv);
        iv =(ImageView)this.findViewById(R.id.iv);
        Animation myyanim = AnimationUtils.loadAnimation(this,R.anim.custanim);
        tv.startAnimation(myyanim);
        iv.startAnimation(myyanim);

        final Intent startMain = new Intent(this,MainActivity.class);

        Thread  timer  = new Thread(){

            @Override
            public void run() {

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(startMain);
                    finish();
                }
            }
        };

        timer.start();

    }
}
