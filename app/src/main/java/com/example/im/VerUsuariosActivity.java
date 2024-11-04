package com.example.im;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class VerUsuariosActivity extends AppCompatActivity {

    private ListView listaUsuarios;
    private BD_IM db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);

        listaUsuarios = findViewById(R.id.idListaUsuarios);
        db = new BD_IM(this);

        ArrayList<String> usersList = db.obUsuarios();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usersList);
        listaUsuarios.setAdapter(adapter);
    }
}