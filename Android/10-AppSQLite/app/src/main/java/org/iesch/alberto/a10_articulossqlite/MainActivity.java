package org.iesch.alberto.a10_articulossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText)findViewById(R.id.textEmail);
        etPassword = (EditText)findViewById(R.id.textPassword);
    }

    //Login
    //Método para comprobar el password y acceder al ActivityPanel si es exitoso
    public void Login(View view){

        String password = etPassword.getText().toString();
        if ( password.equals("1234")){
            Intent intent = new Intent(this, ActivityPanel.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuario y contraseña incorrectos", Toast.LENGTH_LONG).show();
        }

    }
}