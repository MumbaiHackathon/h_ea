package com.example.dhana.eventadda;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectType extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);

         b1 = (Button) findViewById(R.id.btnOrg);
         b2 = (Button) findViewById(R.id.btnUser);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            String profile =b1.getText().toString();
            SharedPreferences sharedPreferencesData = SelectType.this.getSharedPreferences(AppConfig.SHARED_PREF_NAME_DATA, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesData.edit();
            editor.putString(AppConfig.KEY_PROFILE,profile);
            editor.commit();
            Intent i =new Intent(SelectType.this,login.class);
            startActivity(i);

        }

        if(v==b2)
        {
            String profile =b2.getText().toString();
            SharedPreferences sharedPreferencesData = SelectType.this.getSharedPreferences(AppConfig.SHARED_PREF_NAME_DATA, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesData.edit();
            editor.putString(AppConfig.KEY_PROFILE,profile);
            editor.commit();

            Intent i =new Intent(SelectType.this,login.class);
            startActivity(i);
        }

    }
}
