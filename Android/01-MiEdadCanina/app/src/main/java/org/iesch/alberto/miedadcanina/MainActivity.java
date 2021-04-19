package org.iesch.alberto.miedadcanina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "La app fue creada");
        //Context context = getApplicationContext();
        //CharSequence text = "Error al introducir un numero!";
        //int duration = Toast.LENGTH_SHORT;

        //final Toast toast = Toast.makeText(context, text, duration);




        final TextView respuesta = (TextView) findViewById(R.id.respuestaTexto);
        respuesta.setText("Si fueras perro tu edad sería de: ");

        final EditText edadIntroducida = findViewById(R.id.edad);

        final ImageView perro = (ImageView) findViewById(R.id.imagenPerro);
        perro.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dog));

        final Button boton = (Button) findViewById(R.id.miBoton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Logueamos la app


                    String edadString = edadIntroducida.getText().toString();
                    int edadInt = Integer.parseInt(edadString);

                    String textoRespuesta = getString(R.string.respuesta);
                    respuesta.setText(String.format(textoRespuesta,(edadInt*6)));
                    Log.i(TAG,"Hemos introducido un numero correctamente");

                } catch (NumberFormatException e){
                    Log.w(TAG,"Se ha introducido mal la cantidad");
                    //toast.show();
                    //Toast.makeText(getApplicationContext(), "Error al introducir una cantidad", Toast.LENGTH_LONG).show();
                    //Log.w(TAG, "Error al intrucir un numero");
                    Toast.makeText(MainActivity.this, "Error al introducir una cantidad", Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}