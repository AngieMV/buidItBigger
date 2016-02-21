package com.udacity.gradle.builditbigger.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    private static final String TAG = JokesActivity.class.getSimpleName();

    public static final String KEY_JOKE = TAG + "_key_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokes_activity);
        displayJoke();
    }

    private void displayJoke() {
        String joke = getString(R.string.error);;
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getString(KEY_JOKE) != null) {
            joke = getIntent().getExtras().getString(KEY_JOKE);
        }
        ((TextView) findViewById(R.id.joke_textview)).setText(joke);
    }

}
