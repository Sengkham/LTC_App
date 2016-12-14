package com.example.sengkham.ltc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText userEditText, passwordEditText;
    private  String userString,passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText6);


    } // Main Method

    public  void clickSignIn(View view) {
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {
            Log.d("14decV1","have Space");
            MyAlert myAlert = new MyAlert(MainActivity.this,getResources().getString(R.string.title_have_space),getResources().getString(R.string.message_have_space),R.drawable.doremon48);
            myAlert.myDiglog();

        } else {


        }



    }

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }










} // Main class
