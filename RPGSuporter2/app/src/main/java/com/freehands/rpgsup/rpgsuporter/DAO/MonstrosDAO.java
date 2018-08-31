package com.freehands.rpgsup.rpgsuporter.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.freehands.rpgsup.rpgsuporter.Modelo.Monstro;

import java.util.ArrayList;
import java.util.List;

public class MonstrosDAO extends SQLiteOpenHelper {

    public MonstrosDAO(Context context) {
        super(context, "Monstros", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Monstros(id INTEGER PRIMARY KEY," +
                "nome TEXT NOT NULL, vida REAL;";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List buscaMonstros() {
        String sql = "SELECT * FROM Monstros;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Monstro> monstros = new ArrayList<Monstro>();

        while (c.moveToNext()) {
            Monstro monstro = new Monstro();
            monstro.setNome(c.getString(c.getColumnIndex("nome")));
            monstro.setPontosDeVida(c.getDouble(c.getColumnIndex("vida")));

            monstros.add(monstro);
        }
        c.close();

        return monstros;
    }
}
