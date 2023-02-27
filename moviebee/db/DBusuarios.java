package com.example.moviebee.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.moviebee.DBmoviee;
import com.example.moviebee.usuarios;

import java.util.ArrayList;

public class DBusuarios extends DBmoviee {

    Context context;


    public DBusuarios(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context =context;
    }

}
