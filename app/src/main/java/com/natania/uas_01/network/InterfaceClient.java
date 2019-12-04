package com.natania.uas_01.network;

import com.natania.uas_01.model.ResponseDessert;
import com.natania.uas_01.model.ResponseSeaFood;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceClient {
    @GET("filter.php?c=Dessert")
    Call<ResponseDessert> getDessert(
            @Query("strMeal") String strMeal,
            @Query("strMealThumb") String strMealThumb
    );
    @GET("filter.php?c=Seafood")
    Call<ResponseSeaFood> getSeaFood(
            @Query("strMeal")String strMeal,
            @Query("strMealThumb")String strMealThumb
    );
}
