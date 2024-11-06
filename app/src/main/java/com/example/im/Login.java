package com.example.im;

import android.content.Intent;
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

public class Login extends AppCompatActivity {

    private Button btnIniciar;
    private EditText txtNombre;
    private Button btnBack;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIniciar = (Button) findViewById(R.id.idLoginL);
        txtNombre = (EditText) findViewById(R.id.idLog);
        btnBack = (Button) findViewById(R.id.idBack);
        btnCrear = (Button) findViewById(R.id.idCrear);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = ((EditText) findViewById(R.id.idLog)).getText().toString();
                String contra = ((EditText) findViewById(R.id.idContra)).getText().toString();

                BD_IM db = new BD_IM(Login.this);
                if(db.comCredenciales(nombre, contra)) {
                    Intent intent = new Intent(Login.this, Map.class);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                crearUser();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //volver a la anterior
                finish();
            }
        });

    }
    
    public void crearUser(){
        Intent intent = new Intent(this, Registrar.class);
        startActivity(intent);
    }
}