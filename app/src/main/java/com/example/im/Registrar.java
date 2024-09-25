package com.example.im;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrar extends AppCompatActivity {

    private Button btnCrear;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);
        btnBack = (Button) findViewById(R.id.idBack);
        btnCrear = (Button) findViewById(R.id.idCrear);


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Registrar.this, "Usuario creado", Toast.LENGTH_SHORT).show();
                //volver a la anterior
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //volver a la anterior
                finish();
            }
        });

        Spinner spinnerPreferencias = findViewById(R.id.idSpinnerP);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.preferencias_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPreferencias.setAdapter(adapter);

    }
}