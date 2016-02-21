package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Pair;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;

public class EndPointsAsyncTaskTest extends AndroidTestCase {

    private CountDownLatch signal = null;

    private String jokeRetrieved;

    private EndPointsAsyncTask.AsyncTaskListener listener = new EndPointsAsyncTask.AsyncTaskListener() {
        @Override
        public void onComplete(String joke) {
            jokeRetrieved = joke;
            signal.countDown();
        }
    };

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
        jokeRetrieved = null;
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testNoEmptyJoke() throws InterruptedException {
        EndPointsAsyncTask endPoint = new EndPointsAsyncTask();
        endPoint.setmListener(listener).execute(new Pair<Context, String>(getContext(), "Manfred"));
        signal.await();

        Assert.assertNotNull(jokeRetrieved);
    }

}