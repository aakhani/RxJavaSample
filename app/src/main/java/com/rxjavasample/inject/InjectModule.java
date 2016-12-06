package com.rxjavasample.inject;

import android.app.Application;

import com.rxjavasample.Presenters.FragmentAPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

@Module
public class InjectModule {

    private Application mApp;

    public InjectModule(Application mApp) {
        this.mApp = mApp;
    }

    @Singleton
    @Provides
    public FragmentAPresenterImpl getFragmentAPresenter(){
        return  new FragmentAPresenterImpl();
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApp;
    }

}
