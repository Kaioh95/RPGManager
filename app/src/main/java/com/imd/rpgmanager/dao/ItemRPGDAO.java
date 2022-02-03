package com.imd.rpgmanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.imd.rpgmanager.model.ItemRPG;
import com.imd.rpgmanager.utils.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemRPGDAO {

    private final SQLiteDatabase escreve;
    private final SQLiteDatabase le;

    public ItemRPGDAO(Context context){
        DBHelper dbHelper = new DBHelper(context);
        escreve = dbHelper.getWritableDatabase();
        le = dbHelper.getReadableDatabase();
    }

    public boolean salvar(ItemRPG itemRPG){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", itemRPG.getNome());
        contentValues.put("qtditem", itemRPG.getQtdItem());
        contentValues.put("item_personagem_id", itemRPG.getItem_personagem_id());

        try{
            escreve.insert(DBHelper.TABELA_ITENSRPG, null, contentValues);
            Log.i("INFO", "Resgistro de item salvo com sucesso!");
        } catch (Exception e) {
            Log.i("INFO", "ERRO ao salvar resgistro de item! " + e.getMessage());
            return false;
        }

        return true;
    }

    public List<ItemRPG> listar(){

        List<ItemRPG> itens = new ArrayList<>();

        String sql = "SELECT * FROM " +DBHelper.TABELA_ITENSRPG+ ";";

        Cursor cursor = le.rawQuery(sql, null);

        while(cursor.moveToNext()){
            ItemRPG itemRPG = new ItemRPG();

            Long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            int qtditem = cursor.getInt(cursor.getColumnIndexOrThrow("qtditem"));
            Long item_personagem_id = cursor.getLong(cursor.getColumnIndexOrThrow("item_personagem_id"));

            itemRPG.setId(id);
            itemRPG.setNome(nome);
            itemRPG.setQtdItem(qtditem);
            itemRPG.setItem_personagem_id(item_personagem_id);

            itens.add(itemRPG);
        }

        cursor.close();
        return itens;
    }

    public List<ItemRPG> listarPorDono(Long personagem_id){

        List<ItemRPG> itens = new ArrayList<>();
        String[] args = {personagem_id.toString()};

        String sql = "SELECT * FROM " +DBHelper.TABELA_ITENSRPG+ " WHERE item_personagem_id=?;";

        Cursor cursor = le.rawQuery(sql, args);
        while(cursor.moveToNext()){
            ItemRPG itemRPG = new ItemRPG();

            Long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            int qtditem = cursor.getInt(cursor.getColumnIndexOrThrow("qtditem"));
            Long item_personagem_id = cursor.getLong(cursor.getColumnIndexOrThrow("item_personagem_id"));

            itemRPG.setId(id);
            itemRPG.setNome(nome);
            itemRPG.setQtdItem(qtditem);
            itemRPG.setItem_personagem_id(item_personagem_id);

            itens.add(itemRPG);
        }

        cursor.close();
        return itens;
    }

    public boolean atualizar(ItemRPG itemRPG){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", itemRPG.getNome());
        contentValues.put("qtditem", itemRPG.getQtdItem());
        contentValues.put("item_personagem_id", itemRPG.getItem_personagem_id());

        try{
            String[] args = {itemRPG.getId().toString()};
            escreve.update(DBHelper.TABELA_ITENSRPG, contentValues, "id=?", args);
            Log.i("INFO", "Resgistro de item atualizado com sucesso!");
        } catch (Exception e) {
            Log.i("INFO", "ERRO ao atualizar resgistro de item! " + e.getMessage());
            return false;
        }

        return true;
    }

    public boolean deletar(ItemRPG itemRPG){

        try{
            String[] args = {itemRPG.getId().toString()};
            escreve.delete(DBHelper.TABELA_ITENSRPG, "id=?", args);
            Log.i("INFO", "Resgistro de item apagado com sucesso!");
        } catch (Exception e) {
            Log.i("INFO", "ERRO ao apagar registro de item! " + e.getMessage());
            return false;
        }
        return true;
    }

}
