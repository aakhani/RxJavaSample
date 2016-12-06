package com.rxjavasample.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rxjavasample.Presenters.FragmentAPresenter;
import com.rxjavasample.Presenters.FragmentAPresenterImpl;
import com.rxjavasample.R;
import com.rxjavasample.activity.FragmentCallback;
import com.rxjavasample.activity.MainActivity;
import com.rxjavasample.views.FragmentAView;

import javax.inject.Inject;

/**
 * Created by Avdhesh AKhani on 12/2/2016.
 */

public class FragmentA extends Fragment implements FragmentAView{


    FragmentAPresenterImpl presenter;

    private static final String TAG = "Fragment A";
    private FragmentCallback callback;

    public static FragmentA newInstance() {
        FragmentA fragment = new FragmentA();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container, false);

        presenter = new FragmentAPresenterImpl();
        Log.e(TAG, "In Fragment A");
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                presenter.gotoCategoryFragment();
               /* Fragment fragment = CategoryFragment.newInstance();
                if (fragment != null) {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentManager.beginTransaction().add(R.id.frame_container, fragment).addToBackStack("FragmentB").commit();
                }*/
            }
        }, 3000);
        return view;
    }

    @Override
    public void loadCategoryFragment() {
        callback.loadCategoryFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;
        if (context instanceof Activity){
            activity = (Activity)context;
            callback = (FragmentCallback) activity;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.init(this);
    }
}
