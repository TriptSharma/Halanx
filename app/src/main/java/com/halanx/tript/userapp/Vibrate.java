package com.halanx.tript.userapp;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Vibrate extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        img  = (ImageView) findViewById(R.id.profile_image);
    }
    @Override
    protected void onStart() {
        super.onStart();

        try {
            final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Output yes if can vibrate, no otherwise
            if (vibrator.hasVibrator()) {
                Log.v("Can Vibrate", "YES");
            } else {
                Log.v("Can Vibrate", "NO");
            }

            long pattern[] = {0, 1000, 1000};
            vibrator.vibrate(pattern, 0);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vibrator.cancel();
                }
            });
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }
}