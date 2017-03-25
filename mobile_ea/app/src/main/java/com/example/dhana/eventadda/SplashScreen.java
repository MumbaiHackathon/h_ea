package com.example.dhana.eventadda;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private static final int STOPSPLASH = 0;

    private static final long SPLASHTIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
        SharedPreferences sharedPreferences = getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(AppConfig.EMAIL_SHARED_PREF, "Not Available");

        TextView tvName =(TextView)findViewById(R.id.textView3);
        tvName.setText(email);

    }


    private Handler splashHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            SharedPreferences sharedPreferences = getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
            String email = sharedPreferences.getString(AppConfig.EMAIL_SHARED_PREF,"");
            String name = sharedPreferences.getString(AppConfig.NAME_SHARED_PREF, "Not Available");

            switch (msg.what) {
                case STOPSPLASH:
                    if(email !="")
                    {//change
                        Intent intent = new Intent(SplashScreen.this, SelectType.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(SplashScreen.this,SelectType.class);
                        startActivity(intent);

                    }
                    //remove SplashScreen from view
                    finish();
                    break;
            }
            super.handleMessage(msg);
        }
    };



}
