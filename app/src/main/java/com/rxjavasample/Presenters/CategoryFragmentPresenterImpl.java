package com.rxjavasample.Presenters;

import android.util.Log;

import com.rxjavasample.model.Category;
import com.rxjavasample.services.APIService;
import com.rxjavasample.views.CategoryFragmentView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

public class CategoryFragmentPresenterImpl implements CategoryFragmentPresenter{

    private final APIService apiService;
    private CategoryFragmentView categoryFragmentView;


    public CategoryFragmentPresenterImpl() {

        apiService = new APIService();

    }

    @Override
    public void init(CategoryFragmentView view) {
        categoryFragmentView = view;
    }

    @Override
    public void getCategories() {
        apiService.getCategoriesAPI()
                .getCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Category>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Category> category) {

                        String size = category.size()+"";
                        Log.e("Category List size ==>",category.size()+"");

                        categoryFragmentView.showDetails(size);
                    }
                });
    }
}
