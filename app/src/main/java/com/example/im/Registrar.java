package com.example.im;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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
                String nombre = ((EditText) findViewById(R.id.idNombre)).getText().toString();
                String contacto = ((EditText) findViewById(R.id.idContacto)).getText().toString();
                String correo = ((EditText) findViewById(R.id.idCorreo)).getText().toString();
                String contra = ((EditText) findViewById(R.id.idContra)).getText().toString();
                String preferencia = ((Spinner) findViewById(R.id.idSpinnerP)).getSelectedItem().toString();
                String genero = ((CheckBox) findViewById(R.id.checkboxHombre)).isChecked() ? "Hombre" : "Mujer";

                BD_IM db = new BD_IM(Registrar.this);
                if(db.registerUser(nombre, contacto, correo, contra, preferencia, genero)) {
                    Toast.makeText(Registrar.this, "Usuario creado", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Registrar.this, "Error al crear usuario", Toast.LENGTH_SHORT).show();
                }
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