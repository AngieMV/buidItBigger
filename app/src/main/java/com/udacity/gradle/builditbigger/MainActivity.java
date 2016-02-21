package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.View;

import com.udacity.gradle.builditbigger.android.JokesActivity;

public class MainActivity extends ActionBarActivity implements EndPointsAsyncTask.AsyncTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view){
        new EndPointsAsyncTask()
                .setmListener(this)
                .execute(new Pair<Context, String>(this, "Android"));
    }

    @Override
    public void onComplete(String joke) {
        Intent myIntent = new Intent(this, JokesActivity.class);
        myIntent.putExtra(JokesActivity.KEY_JOKE, joke);
        startActivity(myIntent);
    }

}
