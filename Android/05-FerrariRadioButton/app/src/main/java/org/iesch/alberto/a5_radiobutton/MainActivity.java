package org.iesch.alberto.a5_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    RadioButton rb1, rb2, rb3, rb4;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView texto = (TextView) findViewById(R.id.texto);
        final RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);
        final RadioButton rb3 = (RadioButton) findViewById(R.id.rb3);
        final RadioButton rb4 = (RadioButton) findViewById(R.id.rb4);

        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( rb1.isChecked()){
                    texto.setText(" Tu coche favorito es el Ferrari F40");
                }
                if ( rb2.isChecked()){
                    texto.setText(" Tu coche favorito es el Ferrari ENZO");
                }
                if ( rb3.isChecked()){
                    texto.setText(" Tu coche favorito es el Ferrari FXXK");
                }
                if ( rb4.isChecked()){
                    texto.setText(" Tu coche favorito es el Ferrari 321GTO");
                }
            }
        });
    }


}