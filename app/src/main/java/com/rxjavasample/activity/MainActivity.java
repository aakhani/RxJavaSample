package com.rxjavasample.activity;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.rxjavasample.R;
import com.rxjavasample.fragments.CategoryFragment;
import com.rxjavasample.fragments.FragmentA;
import com.rxjavasample.fragments.ReceiptFragment;
import com.rxjavasample.utils.CurrentApplicationPackageRetriever;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements FragmentCallback {

    CurrentApplicationPackageRetriever applicationPackageRetriever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = FragmentA.newInstance();
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.frame_container, fragment).commit();
        }
    }

    @Override
    public void loadCategoryFragment() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, CategoryFragment.newInstance()).commit();
    }

    @Override
    public void gotoRecieptFragment() {

        applicationPackageRetriever = new CurrentApplicationPackageRetriever(this);
        String[] currentActivity = applicationPackageRetriever.get();

        for (String x:currentActivity) {
            Log.e("Current Activity ",x);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ReceiptFragment.newInstance()).commit();
    }
}
