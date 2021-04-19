package com.creatersolutions.monitordeterremotos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 3a - Nos declaramos el ListView y el array que usaremos para meter los datos (a mano)
        ListView terremotoListView = (ListView) findViewById(R.id.eq_list_view);
       // ArrayList<String> paisesList =  new ArrayList<>();

        // Parte B: 12: Nos creamos la lista de Terremotos y le agregamos tres terremotos
        ArrayList<Terremoto> eqList = new ArrayList<>();
        eqList.add(new Terremoto("4.6", "97 kms S of Teruel, España"));
        eqList.add(new Terremoto("3.3", "97 kms S of Joshua, Indonesia"));
        eqList.add(new Terremoto("5.6", "54 kms N of Miami, EEUU"));


        //3b - Nos añadimos los textos que nos van a aparecer en nuestro LisView a mano
        //paisesList.add("México");
        //paisesList.add("EEUU");
        //paisesList.add("España");
        //paisesList.add("Colombia");
        //paisesList.add("Perú");


        // 4 - Nos creamos el Adapter. Es el puente entre nuestro ListView y la pantalla de se mostrará al usuario.
        // Recuerda: Un ListView SIEMPRE ha de ir acompañado de un Adapter
        //ArrayAdapter<String> paisesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paisesList);

        // Parte B: 11: En vez de crear el que viene por defecto creamos un TerremotoAdapter
        //con 3 argumentos: el contexto, el recurso (id del Layout), y la lista de Terremotos
        TerremotoAdapter terremotoAdapter = new TerremotoAdapter(this, R.layout.eq_list_item, eqList);


        //5 - Asignamos nuestro ListView al Adapter. Vamos a insertar los datos
        //terremotoListView.setAdapter(paisesAdapter);

        // Parte B: 13: cambiamos el adapter
        terremotoListView.setAdapter(terremotoAdapter);
    }
}