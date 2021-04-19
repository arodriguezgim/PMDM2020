package com.creatersolutions.a15_pizzeriaretrofit.services;

import com.creatersolutions.a15_pizzeriaretrofit.models.Pizza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PizzaService {
    @GET("/v2/pizzas")
    Call<List<Pizza>> listPizzas();
}
