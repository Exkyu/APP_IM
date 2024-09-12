package com.example.im;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Map extends AppCompatActivity {

    private TextView lbNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        lbNombre = (TextView) findViewById(R.id.idNombreLb);


        Intent intent=getIntent();
        String nombre=intent.getExtras().getString("nombre");
        lbNombre.setText("Bienvenido " + nombre);
    }

}