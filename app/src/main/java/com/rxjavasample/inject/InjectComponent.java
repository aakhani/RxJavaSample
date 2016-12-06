package com.rxjavasample.inject;

import com.rxjavasample.activity.MainActivity;
import com.rxjavasample.fragments.FragmentA;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */


@Singleton
@Component(modules = {InjectModule.class})

public interface InjectComponent {

    void inject(FragmentA fragmentA);
    void inject(MainActivity activity);
}
