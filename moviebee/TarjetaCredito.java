package com.example.moviebee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class TarjetaCredito extends AppCompatActivity {

    TextView Correo,CodSeguridad,Fecha1,Fecha2,Saldo,CodRandomG;
    Bundle recibirDatos;
    String info = "error ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta_credito);
        variables();

        DBmoviee admin = new DBmoviee(this,"DBmoviee", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Correo=findViewById(R.id.UsuarCorreo);

        Correo.setText(info);

      /**  Random random=new Random();
        int val=random.nextInt(100-999);
        CodSeguridad.setText(Integer.toString(val));**/

    }

    private void variables() {

        try {
            recibirDatos=getIntent().getExtras();
            info=recibirDatos.getString("KeyDatosUsu");

        }catch (Exception e){
            e.printStackTrace();
        }
        Correo=findViewById(R.id.UsuarCorreo);
        CodSeguridad=findViewById(R.id.CoDSegDato);
        Fecha1=findViewById(R.id.FechaVencDato);
        Fecha2=findViewById(R.id.fechaVencimiento);
        Saldo=findViewById(R.id.SaldoDato);
        CodRandomG=findViewById(R.id.Numrandom);
    }


}