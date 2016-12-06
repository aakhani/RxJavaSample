package com.rxjavasample.Presenters;

import android.view.View;

import com.rxjavasample.fragments.CategoryFragment;
import com.rxjavasample.model.Category;
import com.rxjavasample.services.APIService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

public class CategoryPresenter {

    CategoryFragment categoryFragment;
    APIService service;

    public CategoryPresenter(CategoryFragment view, APIService service) {
        this.categoryFragment = view;
        this.service = service;
    }


    public void loadCategories(){

        service.getCategoriesAPI()
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
                    }
                });

    }
}
