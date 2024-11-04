package com.example.im;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class BD_IM extends SQLiteOpenHelper {
    // Nombre de la bd y la tabla
    private static final String nombre_BD = "UsuariosBD";
    private static final String nombre_Tabla = "Usuarios";

    // Version de la base de datos
    private static final int version_BD = 1;

    // Columnas de la tabla
    private static final String iD_COLUMNA = "id";
    private static final String nombre_COLUMNA = "nombre";
    private static final String contacto_COLUMNA = "contacto";
    private static final String correo_COLUMNA = "correo";
    private static final String contra_COLUMNA = "contra";
    private static final String preferencias_COLUMNA = "preferencias";
    private static final String genero_COLUMNA = "genero";

    public BD_IM(Context context) {
        super(context, nombre_BD, null, version_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla de usuarios
        String CREATE_USERS_TABLE = "CREATE TABLE " + nombre_Tabla + "("
                + iD_COLUMNA + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + nombre_COLUMNA + " TEXT,"
                + contacto_COLUMNA + " TEXT,"
                + correo_COLUMNA + " TEXT UNIQUE,"
                + contra_COLUMNA + " TEXT,"
                + preferencias_COLUMNA + " TEXT,"
                + genero_COLUMNA + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Borrar la tabla si ya existe
        db.execSQL("DROP TABLE IF EXISTS " + nombre_Tabla);
        onCreate(db);
    }
    // Método para registrar un usuario
    public boolean registerUser(String nombre, String contacto, String correo, String contra, String preferencias, String genero) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(nombre_COLUMNA, nombre);
        values.put(contacto_COLUMNA, contacto);
        values.put(correo_COLUMNA, correo);
        values.put(contra_COLUMNA, contra);
        values.put(preferencias_COLUMNA, preferencias);
        values.put(genero_COLUMNA, genero);

        long result = db.insert(nombre_Tabla, null, values);
        db.close();

        return result != -1; // Retorna verdadero si se inserta correctamente
    }

    // Método para verificar las credenciales de login
    public boolean checkUserCredentials(String correo, String contra) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + nombre_Tabla + " WHERE " + correo_COLUMNA + " = ? AND " + contra_COLUMNA + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{correo, contra});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();

        return exists;
    }
    public ArrayList<String> obUsuarios() {
        ArrayList<String> users = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + nombre_Tabla, null);

        if (cursor.moveToFirst()) {
            do {
                String user = "ID: " + cursor.getInt(0) + ", Nombre: " + cursor.getString(1) + ", Contacto: " + cursor.getString(2) + ", Correo: " + cursor.getString(3);
                users.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return users;
    }
}

