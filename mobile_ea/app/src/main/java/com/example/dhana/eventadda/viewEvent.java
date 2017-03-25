package com.example.dhana.eventadda;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class viewEvent extends AppCompatActivity {
Button btnJoin;
    String titles,dates,locations,teamsize,detils;
TextView eventName,location,desc,date,teamSize,tvHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnJoin = (Button)findViewById(R.id.btnJoin);
        eventName= (TextView)findViewById(R.id.tvEventName);
        location= (TextView)findViewById(R.id.tvLocation);
        desc= (TextView)findViewById(R.id.tvDescription);
        date= (TextView)findViewById(R.id.txtDate);
        teamSize= (TextView)findViewById(R.id.txtTime);
        tvHost= (TextView)findViewById(R.id.txtHostBy);

        Intent i = getIntent();
        {
            i.getExtras();

            titles=i.getStringExtra("titles");
            dates=i.getStringExtra("dates");
            detils=i.getStringExtra("details");
            locations=i.getStringExtra("locations");
            teamsize=i.getStringExtra("teamsizes");


        }
        eventName.setText(titles);
        location.setText(locations);
        desc.setText(detils);
        date.setText(dates);
        teamSize.setText(teamsize);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(viewEvent.this,RegisterEvent.class));

            }
        });
    }

}
