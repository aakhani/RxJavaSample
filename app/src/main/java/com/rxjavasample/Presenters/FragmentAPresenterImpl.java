package com.rxjavasample.Presenters;

import com.rxjavasample.views.FragmentAView;

import javax.inject.Inject;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

public class FragmentAPresenterImpl  implements FragmentAPresenter{

    private FragmentAView fragmentAView;


    public FragmentAPresenterImpl() {

    }

    @Override
    public void gotoCategoryFragment() {
        fragmentAView.loadCategoryFragment();
    }

    @Override
    public void init(FragmentAView view) {
        fragmentAView = view;
    }
}
