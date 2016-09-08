/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.dishantkaushik.myapplication.backend;

import com.example.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import org.json.JSONException;

import java.io.IOException;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.dishantkaushik.example.com",
    ownerName = "backend.myapplication.dishantkaushik.example.com",
    packagePath=""
  )
)
public class MyEndpoint {
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayJoke")
    public MyBean sayJoke() throws IOException, JSONException{
        JokeProvider jp = new JokeProvider();
        MyBean response = new MyBean();
        response.setMyJoke(jp.getRandomJoke());
        return response;
    }

}