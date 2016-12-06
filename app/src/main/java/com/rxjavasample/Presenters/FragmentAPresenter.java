package com.rxjavasample.Presenters;

import com.rxjavasample.activity.BaseFragmentPresenter;
import com.rxjavasample.views.FragmentAView;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

public interface FragmentAPresenter extends BaseFragmentPresenter<FragmentAView> {

    public void gotoCategoryFragment();
}
