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

import com.rxjavasample.Presenters.FragmentAPresenterImpl;
import com.rxjavasample.R;
import com.rxjavasample.activity.FragmentCallback;
import com.rxjavasample.views.FragmentAView;

/**
 * Created by Avdhesh AKhani on 12/2/2016.
 */

public class ReceiptFragment extends Fragment{


    FragmentAPresenterImpl presenter;

    private static final String TAG = "Reciept Fragment";
    private FragmentCallback callback;

    public static ReceiptFragment newInstance() {
        ReceiptFragment fragment = new ReceiptFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container, false);

        Log.e(TAG, "In Receipt Fragment");
        return view;
    }
}
