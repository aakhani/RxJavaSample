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

import com.rxjavasample.Presenters.CategoryFragmentPresenterImpl;
import com.rxjavasample.R;
import com.rxjavasample.activity.FragmentCallback;
import com.rxjavasample.services.APIService;
import com.rxjavasample.views.CategoryFragmentView;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

public class CategoryFragment extends Fragment implements CategoryFragmentView{

    CategoryFragmentPresenterImpl categoryFragmentPresenter;
    private static final String TAG = "CategoryFragment";
    APIService apiService;
    private FragmentCallback callback;

    public static Fragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category,container, false);

        Log.e(TAG, "In Category Fragment ");

        categoryFragmentPresenter = new CategoryFragmentPresenterImpl();

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                categoryFragmentPresenter.getCategories();
                // categoryPresenter = new CategoryPresenter(,apiService)

            }
        }, 5000);
        return view;
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
    public void showDetails(String details) {
        Log.e(TAG, "got Response");
        loadReceiptFragment();
    }

    @Override
    public void setVisible(boolean b) {

    }

    @Override
    public void loadReceiptFragment() {
        callback.gotoRecieptFragment();
    }


    @Override
    public void onResume() {
        super.onResume();
        categoryFragmentPresenter.init(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
