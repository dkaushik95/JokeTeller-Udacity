package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * Created by dishantkaushik on 15/09/16.
 */
public class JokeTest extends TestCase implements OnJokeReceivedListener {

    private CountDownLatch signal;
    private String joke;

    public JokeTest() {
        super();
    }

    public void testJoke() {
        try {
            signal = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(this);
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("joke is null", joke);
            assertFalse("joke is empty", joke.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }

    @Override
    public void onReceived(String joke) {
        this.joke = joke;
        signal.countDown();
    }
}
