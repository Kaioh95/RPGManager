package com.imd.rpgmanager.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static int VERSION = 3;
    public static String NOME_BD = "bd_RPGManager";
    public static String TABELA_PERSONAGENS = "personagens";
    public static String TABELA_ITENSRPG = "itensrpg";

    public DBHelper(@Nullable Context context){
        super(context, NOME_BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_PERSONAGENS
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "nome VARCHAR(50) NOT NULL,"
                + "idade INTEGER,"
                + "sexo VARCHAR(15),"
                + "classe VARCHAR(20),"
                + "raca VARCHAR(20),"

                + "nivel INTEGER,"
                + "forca INTEGER,"
                + "constituicao INTEGER,"
                + "inteligencia INTEGER,"
                + "destreza INTEGER,"
                + "sabedoria INTEGER,"
                + "carisma INTEGER,"
                + "vida INTEGER);";

        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABELA_ITENSRPG
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "nome VARCHAR(50) NOT NULL,"
                + "qtditem INTEGER,"
                + "item_personagem_id INTEGER NOT NULL);"; // chave estrangeira

        try{
            db.execSQL(sql);
            db.execSQL(sql1);
            Log.i("INFO DB", "Sucesso ao criar tabela!");
        } catch (Exception e) {
            Log.i("INFO DB", "ERRO ao criar tabela " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABELA_PERSONAGENS + ";";
        String sql1 = "DROP TABLE IF EXISTS " + TABELA_ITENSRPG + ";";

        try{
            db.execSQL(sql);
            db.execSQL(sql1);
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao criar tabela!");
        } catch (Exception e) {
            Log.i("INFO DB", "ERRO ao criar tabela " + e.getMessage());
            e.printStackTrace();
        }
    }

}
