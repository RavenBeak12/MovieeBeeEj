package com.example.moviebee;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBmoviee extends SQLiteOpenHelper {

    private static  final String Nombre_db="DBmoviee";
    private static  final int Version_db=1;
    private static final String Tabla_usuario=
            "create table registro(Correo text primary key,contraseña int,numtelefono int,CantDinero int,confirmcontraseña int,Fecha int,Fecha2 int,Hora int,CorreoAlt text,ID int)";


    int cantDinero =1000000;


    public DBmoviee(Context context,  String name,  SQLiteDatabase.CursorFactory Nombre_db, int Version_db) {
        super(context, name, Nombre_db, Version_db);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tabla_usuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS Tabla_usuario");
       db.execSQL(Tabla_usuario);


    }

    /**public void agregarUsuarios(String Correo,String numtelefono,String confirmcontraseña){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
         bd.execSQL("INSERT INTO registro VALUES ('"+Correo+"','"+numtelefono+"', '"+confirmcontraseña+"')");
         bd.close();
        }
    }**/

public List<usuarios>mostrarusuarios() {
    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor=db.rawQuery("SELECT * FROM registro",null);
    List<usuarios> usuari =new ArrayList<>();
    if(cursor.moveToFirst()){
        do{
           usuari.add(new usuarios
                   (cursor.getString(0)
                           ,cursor.getString(1),cursor.getString(2)));
        }while (cursor.moveToNext());
    }
    return usuari;
  }

    public usuarios mostUsuariosCorreo(String Correo) {

        usuarios usua = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM registro where Correo='"+Correo+"'",null);

        if(cursor.moveToFirst()){
            do{
                usua =  new usuarios(cursor.getString(0)
                                ,cursor.getString(1),cursor.getString(2));
            }while (cursor.moveToNext());
        }

        return usua;
    }
}
