package org.iesch.alberto.a3_registrodesocios;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Parte B - 4 creamos constante
    public static final int CAMERA_REQUEST_CODE = 1000;

    // - PARTE B: 1 Creamos una variable de tipo ImageView
    ImageView socioImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2 - Creamos un nuevo objeto de tipo socio
        // final Socio nuevoSocio = new Socio();
        // 3 - introduccion public/private
        // nuevoSocio.name = "Perico";
        // nuevoSocio.lastName = "De Los Palotes";


        Button botonRegistrar = (Button) findViewById(R.id.button_registry);

        final EditText nameEdit = (EditText) findViewById(R.id.nameEdit);
        final EditText apellidosEdit = (EditText) findViewById(R.id.last_nameEdit);
        final EditText nickEdit = (EditText) findViewById(R.id.nick_name_edit);
        final EditText edadEdit = (EditText) findViewById(R.id.edad_edit);
        final EditText direccionEdit = (EditText) findViewById(R.id.direccion_edit);
        final EditText ciudadEdit = (EditText) findViewById(R.id.ciudad_edit);

        // - PARTE B: 1 Creamos una variable de tipo ImageView
        //ImageView socioImagen = (ImageView) findViewById(R.id.usuarioImagen);
        socioImagen = (ImageView) findViewById(R.id.usuarioImagen);
        // - PARTE B: 2 Implementamos un onclickListener
        socioImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);

                // 6 - Creamos el objeto al clickar en registrar
                final Socio nuevoSocio = new Socio(
                        nameEdit.getText().toString(),
                        apellidosEdit.getText().toString(),
                        nickEdit.getText().toString(),
                        edadEdit.getText().toString(),
                        direccionEdit.getText().toString(),
                        ciudadEdit.getText().toString()
                );

                // 4 - Se lo pasamos de esta forma y lo mismo para todos los valores del editText
                // De esta manera le pasamos los datos por los setters
                /*
                nuevoSocio.setName(nameEdit.getText().toString());
                nuevoSocio.setLastName(apellidosEdit.getText().toString());
                nuevoSocio.setNickName(nickEdit.getText().toString());
                nuevoSocio.setEdad(edadEdit.getText().toString());
                nuevoSocio.setDireccion(direccionEdit.getText().toString());
                nuevoSocio.setCiudad(ciudadEdit.getText().toString());
                */

                /*
                detailIntent.putExtra("name", nameEdit.getText().toString());
                detailIntent.putExtra("last_name", apellidosEdit.getText().toString());
                detailIntent.putExtra("nick", nickEdit.getText().toString());
                detailIntent.putExtra("edad", edadEdit.getText().toString());
                detailIntent.putExtra("direccion", direccionEdit.getText().toString());
                detailIntent.putExtra("ciudad", ciudadEdit.getText().toString());
                */
                //Ya no necesitamos pasar campo a campo
                detailIntent.putExtra("nuevoSocio",nuevoSocio);

                startActivity(detailIntent);

            }
        });
    }

    // - PARTE B: 3
    private void abrirCamara() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE );
    }

    // - PARTE B: 5 creamos onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE){
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");

            socioImagen.setImageBitmap(bitmap);
        }
    }
}











