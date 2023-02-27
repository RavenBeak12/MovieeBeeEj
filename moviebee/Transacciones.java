package com.example.moviebee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Transacciones extends AppCompatActivity {
    EditText montodinero, correo;
    public Button sigui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacciones);

        montodinero=findViewById(R.id.cantidadDinero);
        correo=findViewById(R.id.Correotransaccion);
        sigui = findViewById(R.id.siguiente);


    }

    public void siguiente(View view) {

        DBmoviee admin = new DBmoviee(this,"DBmoviee", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String correotransc= correo.getText().toString();
        String montDinero=montodinero.getText().toString();
        ContentValues registrar = new ContentValues();

        registrar.put("CantDinero", montDinero);

        if(sigui.isClickable()){

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("quiere realizar la transaccion?").setCancelable(false);

            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {


                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Transacciones.this,"Se realizo la transaccion exitosamente",Toast.LENGTH_SHORT).show();
                    finish();
                }

            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Transacciones.this,"Se cancelo  la transaccion ",Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });

            builder.show();

        }

        /** if(!correotransc.isEmpty() && !montDinero.isEmpty()){
            Cursor cursor = bd.rawQuery("Select correotransc, montDinero from registro where CantDinero='" + montDinero + "'and Correo='" + correotransc + "'", null);
            // Cursor cursor = bd.rawQuery("Select correotransc from registro where Correo='" + correotransc + "'", null);

            if(cursor.moveToFirst()){

            }else{
                Toast.makeText(this, "No se encontraron datos del usuario", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(this, "Debes introducir todos los datos", Toast.LENGTH_SHORT).show();
        }**/

    }//fin del button

}

