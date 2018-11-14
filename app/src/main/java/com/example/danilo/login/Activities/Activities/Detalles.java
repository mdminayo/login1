package com.example.danilo.login.Activities.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.danilo.login.R;

public class Detalles extends AppCompatActivity {

   ImageButton imgbcalendario,imgbgaleria,imgbmapa,imgbdescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        imgbgaleria=findViewById(R.id.imgbgaleria);
        imgbgaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GaleriaActivity.class);
                startActivity(intent);
            }
        });
       /* imgbcalendario= findViewById(R.id.imgbcalendario);
        imgbdescripcion=findViewById( R.id.imgbdescripcion);
        imgbmapa=findViewById(R.id.imgbmapa);

        imgbcalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Principal.class);
                startActivity(intent);
            }
        });
        imgbgaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GaleriaActivity.class);
                startActivity(intent);
            }
        });
        imgbdescripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Aboutus.class);
                startActivity(intent);
            }
        });
        imgbmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Notificaciones.class);
                startActivity(intent);
            }
        });*/
    }
}
