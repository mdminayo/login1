package com.example.danilo.login.Activities.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.danilo.login.R;

public class MenuActivity extends AppCompatActivity {

    ImageButton imgBlista,imgBconfig,imgBabout,imgBalertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imgBlista= findViewById(R.id.imgBlista);
        imgBconfig=findViewById(R.id.imgBconfig);
        imgBabout=findViewById( R.id.imgBabout);
        imgBalertas=findViewById(R.id.imgBalertas);

        imgBlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Principal.class);
                startActivity(intent);
            }
        });
        imgBconfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Configuracion.class);
                startActivity(intent);
            }
        });
        imgBabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Aboutus.class);
                startActivity(intent);
            }
        });
        imgBalertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Notificaciones.class);
                startActivity(intent);
            }
        });
    }


}
