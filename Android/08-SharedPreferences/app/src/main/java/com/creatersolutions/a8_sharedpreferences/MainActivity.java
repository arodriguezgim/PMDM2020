package com.creatersolutions.a8_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etEmail = (EditText)findViewById(R.id.etEmail);

        //Al iniciar la aplicacion debe mostrar lo que tiene guardado en el archivo SharedPreferences
        //Obtengo los valores que se han creado previamente, si hay.
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Aqui  tenemos que poner LA REFERENCIA del Valor que buscamos. El par de comillas suelto es el valor inicial si no hay ningun valor.
        etNombre.setText(preferences.getString("nombre", ""));
        etEmail.setText(preferences.getString("mail", ""));
    }

    //Método para el boton Guardar
    public void Guardar(View view){

        //En este caso tenemos que crear el objeto nuevamente.
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Editor es la Clase que me sirve para modificar este archivo
        //Vamos a editar el archivo SharedPreferences
        SharedPreferences.Editor Obj_editor = preferencias.edit();

        Obj_editor.putString("nombre", etNombre.getText().toString());
        Obj_editor.putString("mail", etEmail.getText().toString());
        //Commit confirma que lo que acabamos de recuperar arriba lo queremos GUARDAR. Sin Commit no guarda nada en SharedPreferences
        Obj_editor.commit();

        finish();

    }
}