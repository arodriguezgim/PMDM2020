package org.iesch.alberto.a14_recyclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RestauranteFragment extends Fragment {

    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adaptadorRestaurantes;
    List<Restaurante> restauranteList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    public RestauranteFragment() {
    }


    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
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
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // LISTA DE RESTAURANTES
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Pizzería Don Topo", "Ensache, Teruel, España", "https://s4.eestatic.com/2019/03/06/social/Pizza-Redes_sociales-Premios-La_Jungla_381223734_117184033_1706x960.jpg", 4.0f));
            restauranteList.add(new Restaurante("Bar Le Tour", "Fuenfresca, Teruel, España", "https://media.revistagq.com/photos/5f08621564f52a842c7f9a83/16:9/w_1920%2cc_limit/hamburguesa%20the%20fitzgerald.jpg", 3.0f));
            restauranteList.add(new Restaurante("Pizzería Los Caprichos", "Centro, Teruel, España", "https://s6.eestatic.com/2018/04/16/cocinillas/Cocinillas_300234384_116528836_1706x960.jpg", 2.0f));
            restauranteList.add(new Restaurante("Baar IES Chomon", "Poligono Sur, Teruel, España", "https://www.metropoliabierta.com/uploads/s1/27/23/71/el-bocadillo-de-albo-ndigas-de-can-ros_9_1200x480.jpeg", 5.0f));

            //Asignamos el recyclerView al adaptador

            adaptadorRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity() ,restauranteList);
            recyclerView.setAdapter(adaptadorRestaurantes);
        }
        return view;
    }
}