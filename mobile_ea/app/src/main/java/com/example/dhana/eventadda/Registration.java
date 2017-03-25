package com.example.dhana.eventadda;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
EditText etREmail,etRPassword;
        Button btnReg,btnLoginLink;
    private ProgressDialog pDialog;
    String Remail,Rname,Rpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        etREmail=(EditText)findViewById(R.id.etEmail);
        etRPassword=(EditText)findViewById(R.id.etPassword);
        btnReg=(Button)findViewById(R.id.btnReg);
        btnLoginLink=(Button)findViewById(R.id.btnLoginLink);
        btnLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Registration.this,login.class);
                startActivity(intent );
                finish();
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rname=etREmail.getText().toString();
                Remail=etREmail.getText().toString();
                Rpassword=etRPassword.getText().toString();
                registerUser(Rname, Remail, Rpassword);

            }
        });

    }

    private void registerUser(final String name, final String email, final String password)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.regURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),login.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(AppConfig.KEY_NAME,name);
                params.put(AppConfig.KEY_PASSWORD,password);
                params.put(AppConfig.KEY_EMAIL,email);
                // params.put("job",Job);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
