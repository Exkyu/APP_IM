package com.example.im;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrar extends AppCompatActivity {

    private Button btnCrear;
    private EditText txtNombre;
    private EditText txtContacto;
    private EditText txtCorreo;
    private  EditText txtContra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);

        txtNombre = (EditText) findViewById(R.id.idNombre);
        txtContacto = (EditText) findViewById(R.id.idContacto);
        txtContra = (EditText) findViewById(R.id.idContra);
        txtCorreo = (EditText) findViewById(R.id.idCorreo);
        btnCrear = (Button) findViewById(R.id.idCrear);


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Registrar.this, "Usuario creado", Toast.LENGTH_SHORT).show();
                //volver a la anterior
                finish();
            }
        });
    }
}