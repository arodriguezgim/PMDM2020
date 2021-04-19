package org.iesch.alberto.a3_registrodesocios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView respuesta = (TextView) findViewById(R.id.respuesta);

        //Este getExtras va a contener todos valores
        Bundle extras = getIntent().getExtras();

        // 8 - Recibimos el objeto Socio
        Socio nuevoSocio = extras.getParcelable("nuevoSocio");
        /* Ya no necesitamos nada de esto
        String name = extras.getString("name");
        String last_name = extras.getString("last_name");
        String nick = extras.getString("nick");
        String edad = extras.getString("edad");
        String direccion = extras.getString("direccion");
        String ciudad = extras.getString("ciudad");
        */

        //Mostramos por pantalla todos los valores que hemos recibido
        //respuesta.setText(name + " ," + last_name + " ," + nick + " ," + edad + " ," + direccion + " ," + ciudad);
        //Punto 8
        if (nuevoSocio != null) {
            respuesta.setText(nuevoSocio.getName() + " ," + nuevoSocio.getLastName() + " ," + nuevoSocio.getNickName() + " ," + nuevoSocio.getEdad() + " ," + nuevoSocio.getDireccion() + " ," + nuevoSocio.getCiudad());
        }


    }
}