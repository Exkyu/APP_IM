package com.example.im;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private Button btnIniciar;
    private EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIniciar = (Button) findViewById(R.id.idLoginL);
        txtNombre = (EditText) findViewById(R.id.idNombre);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conectM();
            }
        });
    }

    public void conectM(){
        Intent intent = new Intent(this,Map.class);
        String nombreparametro=txtNombre.getText().toString();
        intent.putExtra("nombre",nombreparametro);
        startActivity(intent);
    }
}