package com.example.danielamarcela.juegocolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button iniciarPantalla,juegoPantallla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarPantalla=findViewById(R.id.iniciar);
        juegoPantallla=findViewById(R.id.juego);

        iniciarPantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ventana2=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(ventana2);

            }
        });

        juegoPantallla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana3=new Intent(MainActivity.this, Main3Activity.class);
                startActivity(ventana3);

            }
        });
    }
}
