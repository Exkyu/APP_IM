package com.example.im;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Map2 extends AppCompatActivity {

    private TextView lbNombre;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map2);

        btnBack =(Button) findViewById(R.id.idBack);
        lbNombre = (TextView) findViewById(R.id.idNombreLb);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //volver a la anterior
                finish();
            }
        });

        lbNombre.setText("Bienvenido ");

    }
}