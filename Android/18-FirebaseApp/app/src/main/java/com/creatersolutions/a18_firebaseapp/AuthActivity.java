package com.creatersolutions.a18_firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {

    Button registro, login;
    EditText email, contrasena;

    //1-Creamos una instancia de Firebase
    private FirebaseAuth mAuth;

    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        email = findViewById(R.id.emailEditText);
        contrasena = findViewById(R.id.passwordEditText);
        registro = findViewById(R.id.registerButton);
        login = findViewById(R.id.loginbutton);

        setTitle("Autenticacion");
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        //Con este bloque estaremoslanzando eventos personalizados a Google Analitycs
        Bundle bundle = new Bundle();
        bundle.putString("message","Integracion de Firebase completa");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        // 2- Inicializamos la instancia Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);

    }

    private void login() {
        final String _email = email.getText().toString();
        String _password = email.getText().toString();

        mAuth.signInWithEmailAndPassword(_email, _password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FIREBASE AUTH", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(AuthActivity.this, HomeActivity.class);
                            i.putExtra("email", _email);
                            //i.putExtra("email", _email);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FIREBASE AUTH", "signInWithEmail:failure", task.getException());
                            Toast.makeText(AuthActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);

                        }

                    }
                });
    }

    private void registrar() {

        String _email = email.getText().toString();
        String _password = email.getText().toString();

        mAuth.createUserWithEmailAndPassword(_email, _password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FIREBASE", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FIREBASE", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(AuthActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                    }
                });
    }
}