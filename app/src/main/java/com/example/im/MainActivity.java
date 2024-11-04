package com.example.im;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnShowMap;
    private Button btnOut;
    private Button btnVerUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.idLogin);
        btnShowMap = (Button) findViewById(R.id.idShowMap);
        btnOut = (Button) findViewById(R.id.idOut);
        btnVerUsuarios = (Button) findViewById(R.id.idVerUsuarios);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conectL();
            }
        });

        btnShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conectM();
            }
        });

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnVerUsuarios.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, VerUsuariosActivity.class);
            startActivity(intent);
        });

    }

    public void conectL(){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
    public void conectM(){
        Intent intent = new Intent(this, Map2.class);
        startActivity(intent);
    }

}