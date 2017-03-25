package com.example.dhana.eventadda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterEvent extends AppCompatActivity {
Button btnRegEvent;
    EditText name,email,mobile,teamSize,teamName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_event);
        btnRegEvent= (Button)findViewById(R.id.btnRegEvent);
     /*   name =(EditText)findViewById(R.id.etVName);
        email =(EditText)findViewById(R.id.etVEmail);
        mobile =(EditText)findViewById(R.id.etVMobile);
        teamSize=(EditText)findViewById(R.id.etVTeamSize);
        teamName=(EditText)findViewById(R.id.etVTeamName);
*/


        btnRegEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterEvent.this,UserQr.class));

            }
        });
    }
}
