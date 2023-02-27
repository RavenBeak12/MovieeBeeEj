package com.example.moviebee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void iniciarsecion(View view){
        Intent siguiente=new Intent(this,Iniciodesesion.class);
        startActivity(siguiente);
    }
     public void registrarse(View view){
        Intent siguiente=new Intent(this,registrodeusuario.class);
        startActivity(siguiente);

    }
}