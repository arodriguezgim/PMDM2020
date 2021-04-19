package org.iesch.alberto.a6_edadesdam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String nombres [] = {"Pedro", "Mario", "Ashley", "Alvaro", "Jorge", "Ángel", "Raúl", "Eduardo"};
    private String edades [] = {"19", "20", "19", "27", "19", "21", "21", "27"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        lv1 = (ListView) findViewById(R.id.lv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_dam, nombres);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.d("MANZANA", String.valueOf(position));
                tv1.setText("La edad de " + lv1.getItemAtPosition(position) + " es " + edades[position] + " años.");
            }
        });
    }
}