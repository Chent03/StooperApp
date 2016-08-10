package com.cs6392016.gbergy.stooperapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SplashActivity extends Activity {

    private static final int SPLASH_DISPLAY_TIME = 3000; // SHOW SPLASH FOR 3 SECONDS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent mapIntent = new Intent(SplashActivity.this, DrawerActivity.class);

                SplashActivity.this.startActivity(mapIntent);

                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_TIME);

    }

}
