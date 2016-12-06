package com.rxjavasample.Presenters;

import com.rxjavasample.activity.BaseFragmentPresenter;
import com.rxjavasample.fragments.ReceiptFragment;
import com.rxjavasample.views.CategoryFragmentView;
import com.rxjavasample.views.FragmentAView;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

public interface CategoryFragmentPresenter extends BaseFragmentPresenter<CategoryFragmentView> {

    public void getCategories();

}
