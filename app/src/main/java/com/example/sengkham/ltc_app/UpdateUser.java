package com.example.sengkham.ltc_app;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import okio.BufferedSink;

/**
 * Created by Sengkham on 14/12/2016.
 */

public class UpdateUser extends AsyncTask<Void,Void,String>{
    private static final String urlPHP = "http://swiftcodingthai.com/ltc/add_user_nou.php";
    private Context context;
    private String nameString,userString,passwordString;

    public UpdateUser(Context context, String nameString, String userString, String passwordString) {
        this.context = context;
        this.nameString = nameString;
        this.userString = userString;
        this.passwordString = passwordString;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd","true")
                    .add("Name",nameString)
                    .add("User",userString)
                    .add("Password",passwordString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response  = okHttpClient.newCall(request).execute();
            return response.body().string();

        }catch(Exception e){

            Log.d("14devV1", "e doin ==> " + e.toString());
            return null;
        }



    }
} // Main Class