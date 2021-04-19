package org.iesch.alberto.a17_misnotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.iesch.alberto.a17_misnotas.screens.RegistroActivity;


public class MainActivity extends AppCompatActivity {

    private TextView btnRegistrar;
    private Button btnLogin;
    //1- Creamos una instancia de Firebase
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistrar = findViewById(R.id.textIrALogin);
        btnLogin = findViewById(R.id.btnRegistrar);

        // Obtenemos la instancia de FirebaseAnalytics..
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        //COMIENZO A REGISTRAR EVENTOS
        Bundle bundle = new Bundle();
        bundle.putString("mensaje","Integracion con Firebase completa.");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        //AUTENTICACION
        mAuth = FirebaseAuth.getInstance();



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotasActivity.class);
                startActivity(intent);
            }
        });

        //Para cuando hacemos click en Registrarse - IR A REGISTRO
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
}