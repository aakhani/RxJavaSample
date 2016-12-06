package com.rxjavasample.services;

import com.rxjavasample.model.Category;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Avdhesh AKhani on 12/5/2016.
 */

public class APIService {


    private static final String BASE_URL = "http://app-api.offers.net";
    private CategoriesAPI categoriesAPI;

    public APIService() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        categoriesAPI = restAdapter.create(CategoriesAPI.class);

    }

    public CategoriesAPI getCategoriesAPI(){
        return  categoriesAPI;
    }

    public interface CategoriesAPI{

        @GET("/categories")
        public Observable<List<Category>> getCategories();
    }
}
