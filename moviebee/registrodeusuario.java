package com.example.moviebee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registrodeusuario extends AppCompatActivity {
    public EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrodeusuario);

        et1 = findViewById(R.id.Correo);
        et2 = findViewById(R.id.numtelefonico1);
        et3 = findViewById(R.id.montoDinero);
        et4 = findViewById(R.id.confirmcontraseña);

    }
    public void registrar(View view) {
        DBmoviee admin = new DBmoviee(this,"DBmoviee", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String correo = et1.getText().toString();
        String numtelefono = et2.getText().toString();
        String contraseña = et3.getText().toString();
        String confirmcontraseña = et4.getText().toString();

        ContentValues registrar = new ContentValues();

        registrar.put("Correo", correo);
        registrar.put("contraseña", contraseña);
        registrar.put("numtelefono", numtelefono);
        registrar.put("confirmcontraseña", confirmcontraseña);

        if (!correo.isEmpty() && !contraseña.isEmpty() && !numtelefono.isEmpty() && !confirmcontraseña.isEmpty()) {

            if (!contraseña.equals(confirmcontraseña)) {
                Toast.makeText(this, "Contraseña no coincide", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Iniciodesesion.class);
                startActivity(i);

            }
        } else {
            seterror();
            return;
        }
        bd.insert("registro", null, registrar);
        bd.close();
    }

    private boolean seterror() {
        boolean devolver = true;
        String correo = et1.getText().toString();
        String numtelefono = et2.getText().toString();
        String contraseña = et3.getText().toString();
        String confirmcontraseña = et4.getText().toString();

        if (correo.isEmpty()) {
            et1.setError("No puede quedar vacio");
            devolver = false;
        }
        if (numtelefono.isEmpty()) {
            et2.setError("No puede quedar vacio");
            devolver = false;
        }
        if (contraseña.isEmpty()) {
            Toast.makeText(this, "Ingrese una contraseñal", Toast.LENGTH_SHORT).show();
            devolver = false;
        }
        if (confirmcontraseña.isEmpty()) {
            Toast.makeText(this, "Confirme su contraseñal", Toast.LENGTH_SHORT).show();
            devolver = false;
        }
        return devolver;
    }
    public boolean usuario() {
        DBmoviee usu = new DBmoviee(this,"DBmoviee", null, 1);
        SQLiteDatabase bd = usu.getWritableDatabase();
        String contraseña = et1.getText().toString();
        Cursor fila=bd.rawQuery("select usuario from AdminSQLiteOpenHelper where contraseña'"+contraseña+ "'",null);

        if(fila.moveToFirst()){
            fila.close();
            bd.close();
            return false;
        }
        return false;
    }
}