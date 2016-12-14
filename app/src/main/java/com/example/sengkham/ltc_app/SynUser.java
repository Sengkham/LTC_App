package com.example.sengkham.ltc_app;

import android.content.Context;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

/**
 * Created by Sengkham on 14/12/2016.
 */

public class SynUser extends AsyncTask<Voice,Voice,String> {
    private Context context;
    private static final String urlJSON = "http://swiftcodingthai.com/ltc/get_user_data_nou.php";

    public SynUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Voice... params) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();


        } catch (Exception e) {
            Log.d("14decV2","e doin ==> " + e.toString());


        }


        return null;
    }
}
