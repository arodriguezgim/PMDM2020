package org.iesch.alberto.a17_misnotas.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.iesch.alberto.a17_misnotas.R;
import org.iesch.alberto.a17_misnotas.models.Nota;

import java.util.ArrayList;
import java.util.List;


public class NotaFragment extends Fragment {

    //Necesitare una lista de Notas
    private List<Nota> notalist;

    private MyNotaRecyclerViewAdapter adapterNotas;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
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
        View view = inflater.inflate(R.layout.fragment_nota_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(mColumnCount, StaggeredGridLayoutManager.VERTICAL));
            }

            //Vamosa crearnos algunas notas
            notalist = new ArrayList<>();
            notalist.add(new Nota("Lista de la compra", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco", true, android.R.color.holo_blue_light));
            notalist.add(new Nota("Recordar", "He aparcado el coche en el Vado. No olvidarme de pagar el parkimetro", false, android.R.color.holo_orange_light));
            notalist.add(new Nota("Cumpleaños (fiesta)", "No olvidar la Ginebra", true, android.R.color.holo_green_light));
            //Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu

            adapterNotas = new MyNotaRecyclerViewAdapter(notalist);
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }
}