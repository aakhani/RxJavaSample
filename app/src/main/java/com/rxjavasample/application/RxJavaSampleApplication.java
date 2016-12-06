package com.rxjavasample.application;

import android.app.Application;

import com.rxjavasample.inject.DaggerFragmentAPresenerComponent;
import com.rxjavasample.inject.InjectComponent;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

public class RxJavaSampleApplication extends Application {

  InjectComponent injectComponent;
    @Override
    public void onCreate() {
        super.onCreate();

    }
}
