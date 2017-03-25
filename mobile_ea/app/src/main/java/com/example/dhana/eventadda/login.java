package com.example.dhana.eventadda;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    private Button btnRegLink, btnLogin;
    private EditText etEmail, etPassword;
    private boolean loggedIn = false;
    private Session session;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferencesData = login.this.getSharedPreferences(AppConfig.SHARED_PREF_NAME_DATA, Context.MODE_PRIVATE);
        final String profile1=(sharedPreferencesData.getString(AppConfig.KEY_PROFILE, "NA"));
        setTitle(profile1 +" Login");

        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnRegLink=(Button)findViewById(R.id.btnRegLink);
        btnRegLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(login.this,UserHome.class);
                startActivity(intent );
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String profile =profile1.toString();

                if (!isValidEmail(email)) {
                    etEmail.setError("Invalid Email");
                    etEmail.requestFocus();
                }
                else if (email.trim().length() == 0) {

                    etEmail.setError( "Please enter the credentials!");
                    etEmail.requestFocus();
                }
                else if (password.trim().length() == 0) {
                    etPassword.setError( "Please enter Password!");
                    etPassword.requestFocus();
                }
                else {

                    checkLogin(email, password);
                }


                // checkLogin(email, password,profile);
                //startActivity(new Intent(login.this,viewEvent.class));



            }
        });

    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    //login
    private void checkLogin(final String email, final String password) {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.loginURL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                    if(response.equals("login successful"))

                    {
                        SharedPreferences sharedPreferencesData = login.this.getSharedPreferences(AppConfig.SHARED_PREF_NAME_DATA, Context.MODE_PRIVATE);
                        final String profile1=(sharedPreferencesData.getString(AppConfig.KEY_PROFILE, "NA"));

                        String profile =profile1.toString();


                       /* session.setLogin(true);
                        SharedPreferences sharedPreferences = login.this.getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                        loggedIn = sharedPreferences.getBoolean(AppConfig.LOGGEDIN_SHARED_PREF, false);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(AppConfig.LOGGEDIN_SHARED_PREF, true);*/
                       // editor.putString(AppConfig.EMAIL_SHARED_PREF, email);

                        //editor.commit();
                        if (profile.equals("User")){
                            Intent intent = new Intent(login.this, UserHome.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Intent intent = new Intent(login.this, orgHome.class);
                            startActivity(intent);
                            finish();
                        }

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),response, Toast.LENGTH_LONG).show();
                    }

                    //  editor.putString(AppConfig.KEY_LASTNAME, lastname);
                    //editor.putString(AppConfig.Login_mode, "account");
                    // editor.putString(AppConfig.NAME_SHARED_PREF, name);

                }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Invalid data", Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Post params to login url
                Map<String, String> params = new HashMap<String, String>();

                params.put(AppConfig.KEY_EMAIL, email);
                params.put(AppConfig.KEY_PASSWORD, password);


                return params;
            }

        };

        // Adding request to  queue
        AppController.getInstance().addToRequestQueue(strReq);
    }


}
