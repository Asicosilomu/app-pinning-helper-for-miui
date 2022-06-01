package com.asicosilomu.miuipinhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // function from https://stackoverflow.com/questions/39754698/screen-pinning-unreliable-sometimes-asks-for-passcode-on-awakening-other-times/39757763#39757763
    // ty

    public boolean isAppInLockTaskMode() {
        ActivityManager activityManager=(ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M) { // When SDK version is 23
            int lockTaskMode=activityManager.getLockTaskModeState();
            return lockTaskMode != ActivityManager.LOCK_TASK_MODE_NONE ? true : false;
        }
        else if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP &&
                Build.VERSION.SDK_INT< Build.VERSION_CODES.M) {
            //When SDK version <=21 and <23. This API is deprecated in 23.
            return activityManager.isInLockTaskMode();
        }
        else {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button doit = findViewById(R.id.dothethingy);
        doit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLockTask();
                while (isAppInLockTaskMode() != true)
                {
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.exit(0);
            }
        });
    }
}