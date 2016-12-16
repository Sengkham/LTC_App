package com.example.sengkham.ltc_app;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


/**
 * Created by Sengkham on 14/12/2016.
 */

public class SynUser extends AsyncTask<Void,Void,String> {
    private Context context;
    private static final String urlJSON = "http://lao-hosting.com/ltc/get_user_master.php";

    public SynUser(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(Void... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response =  okHttpClient.newCall(request).execute();
            return  response.body().string();


        } catch (Exception e) {
            Log.d("14decV2","e doin ==> " + e.toString());


        }

        return null;
    }
}
