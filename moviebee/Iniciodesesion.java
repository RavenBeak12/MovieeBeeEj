package com.example.moviebee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Iniciodesesion extends AppCompatActivity {
    public EditText etcorreo, etcontraseña;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciodesesion);
        etcorreo = findViewById(R.id.Correo2);
        etcontraseña = findViewById(R.id.montoDinero);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                IniciarSesion();
            }
        });
    }

    public void IniciarSesion() {
        //ABRO LA BASE DE DATOS
        DBmoviee admin = new DBmoviee(this,"DBmoviee", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();


        String correo = etcorreo.getText().toString();
        String contraseña = etcontraseña.getText().toString();


        //PONGO LAS CONDICIONES
        if (!correo.isEmpty() && !contraseña.isEmpty()) {

            usuarios usua = null;
            Cursor cursor = bd.rawQuery("Select * from registro where contraseña='" + contraseña + "'and Correo='" + correo + "'", null);

            if (cursor.moveToFirst()) {
                do{
                    usua =  new usuarios(cursor.getString(0)
                            ,cursor.getString(1),cursor.getString(2));
                }while (cursor.moveToNext());
                Bundle enviarDatos =new Bundle();
                enviarDatos.putString("KeyDatosUsu", usua.getCorreo());
                enviarDatos.putString("keydatostel",usua.getNumtelefono());
                enviarDatos.putString("keydatosCont",usua.getContraseña());

                Intent intent=new Intent(Iniciodesesion.this,pantallainicio.class);

                intent.putExtras(enviarDatos);

                startActivity(intent);
            } else {
                Toast.makeText(this, "No se encontraron datos del usuario", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(this, "Debes introducir un correo y una contraseña", Toast.LENGTH_SHORT).show();

        }


    }
}