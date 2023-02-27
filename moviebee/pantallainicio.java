package com.example.moviebee;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class pantallainicio extends AppCompatActivity {
    TextView Correos,numerotel,contraseña,dinero;
    Button transaccion, historial,tarjeta;
    Bundle recibirDatos;
    String info = "error ";
    String info2 = "error ";
    String info3 = "error ";
    String cantDinero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallainicio);
        initVariables();


        DBmoviee admin = new DBmoviee(this,"DBmoviee", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();


        Correos.setText("Bienvenido " + info);
        numerotel.setText(info2);
        contraseña.setText(info3);

    }

    private void initVariables() {

        try {
            recibirDatos=getIntent().getExtras();
            info=recibirDatos.getString("KeyDatosUsu");
            info2=recibirDatos.getString("keydatostel");
            info3=recibirDatos.getString("keydatosCont");



        }catch (Exception e){
            e.printStackTrace();
        }

        Correos=findViewById(R.id.correos);
        numerotel=findViewById(R.id.numertel);
        contraseña=findViewById(R.id.contras);
        dinero=findViewById(R.id.cantDinero);
        transaccion=(Button) findViewById(R.id.Transacciones);
        historial=(Button) findViewById(R.id.historial);
        tarjeta=(Button) findViewById(R.id.tarjetac);
    }

    public void transacciones(View view){
        Intent i = new Intent(this,Transacciones.class);
        startActivity(i);
    }

    public void tarjeta(View view){

        Intent i = new Intent(this,TarjetaCredito.class);

        startActivity(i);
    }

}


