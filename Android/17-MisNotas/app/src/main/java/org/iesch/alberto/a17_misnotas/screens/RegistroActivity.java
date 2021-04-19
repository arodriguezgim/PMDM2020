package org.iesch.alberto.a17_misnotas.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.iesch.alberto.a17_misnotas.MainActivity;
import org.iesch.alberto.a17_misnotas.R;

public class RegistroActivity extends AppCompatActivity {

    private TextView btnIrALogin, txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnIrALogin = findViewById(R.id.textIrALogin);
        txtEmail = findViewById(R.id.et_EmailR);
        txtPassword = findViewById(R.id.et_PasswordR);

        //Para cuando hacemos click en Registrarse - IR A REGISTRO
        btnIrALogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}