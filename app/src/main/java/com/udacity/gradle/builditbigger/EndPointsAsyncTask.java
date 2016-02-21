package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class EndPointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static final String GOOGLE_CLOUD_SOLUTION = "builditbiggerfin";

    private static MyApi myApiService = null;

    private AsyncTaskListener mListener = null;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://" + GOOGLE_CLOUD_SOLUTION + ".appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        Context context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public EndPointsAsyncTask setmListener(AsyncTaskListener mListener) {
        this.mListener = mListener;
        return this;
    }

    @Override
    protected void onPostExecute(String result) {
        if (mListener != null) {
            mListener.onComplete(result);
        }
    }

    public interface AsyncTaskListener {
        void onComplete(String joke);
    }
}