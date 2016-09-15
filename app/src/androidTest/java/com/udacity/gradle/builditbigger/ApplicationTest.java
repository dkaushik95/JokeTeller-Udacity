package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.joketellingandroidlibrary.Joke;

import junit.framework.TestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends TestCase {

    public ApplicationTest() {
        super();
        JokeTest jokeTest = new JokeTest();
        jokeTest.testJoke();

    }
}