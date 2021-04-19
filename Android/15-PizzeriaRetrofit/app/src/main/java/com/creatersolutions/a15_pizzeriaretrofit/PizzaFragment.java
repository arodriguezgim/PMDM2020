package com.creatersolutions.a15_pizzeriaretrofit;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creatersolutions.a15_pizzeriaretrofit.models.Pizza;
import com.creatersolutions.a15_pizzeriaretrofit.services.PizzaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PizzaFragment extends Fragment {

    public static final String BASE_URL = "https://private-3cc5a4-codingpizza.apiary-mock.com";
    Retrofit retrofit;
    RecyclerView recyclerView;

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 2;


    public PizzaFragment() {
    }

    public static PizzaFragment newInstance(int columnCount) {
        PizzaFragment fragment = new PizzaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizza_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //USO RETROFIT PARA OBTENER LAS PIZZAS
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getPizzaList(retrofit);


            //recyclerView.setAdapter(new MyPizzaRecyclerViewAdapter(getPizzaList(retrofit)));
        }
        return view;
    }

    private void getPizzaList(Retrofit retrofit) {
        PizzaService pizzaService = retrofit.create(PizzaService.class);
        Call<List<Pizza>> pizzaList = pizzaService.listPizzas();
        Log.i("PIZZA", String.valueOf(pizzaList));
        pizzaList.enqueue(new Callback<List<Pizza>>() {
            @Override
            public void onResponse(Call<List<Pizza>> call, Response<List<Pizza>> response) {
                if (response.isSuccessful()){
                    recyclerView.setAdapter(new MyPizzaRecyclerViewAdapter(response.body()));
                    return;
                } else {
                    Log.e("PIZZA", "onResponse: Llamada fallida en onResponse");
                }
            }

            @Override
            public void onFailure(Call<List<Pizza>> call, Throwable t) {
                Log.e("PIZZA", "onResponse: Llamada fallida");
            }
        });
    }

    /*
        pizzaList.enqueue(new Callback<List<Pizza>>() {
        @Override
        public void onResponse(Call<List<Pizza>> call, Response<List<Pizza>> response) {
            if (response.isSuccessful()) {
                mAdapter = new CustomAdapter(response.body());
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.setLayoutManager(mLayoutManager);
            } else {
                Log.e(TAG, "onResponse: Llamada fallida");
            }
        }

     */
}