package com.imd.rpgmanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.imd.rpgmanager.model.ItemRPG;
import com.imd.rpgmanager.model.Personagem;
import com.imd.rpgmanager.utils.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

    private final SQLiteDatabase escreve;
    private final SQLiteDatabase le;

    public PersonagemDAO(Context context){
        DBHelper dbHelper = new DBHelper(context);
        escreve = dbHelper.getWritableDatabase();
        le = dbHelper.getWritableDatabase();
    }

    public boolean salvar(Personagem personagem){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", personagem.getNome());
        contentValues.put("idade", personagem.getIdade());
        contentValues.put("sexo", personagem.getSexo());
        contentValues.put("classe", personagem.getClasse());
        contentValues.put("raca", personagem.getRaca());

        contentValues.put("nivel", personagem.getNivel());
        contentValues.put("forca", personagem.getForca());
        contentValues.put("constituicao", personagem.getConstituicao());
        contentValues.put("inteligencia", personagem.getInteligencia());
        contentValues.put("destreza", personagem.getDestreza());
        contentValues.put("sabedoria", personagem.getSabedoria());
        contentValues.put("carisma", personagem.getCarisma());
        contentValues.put("vida", personagem.getVida());

        try{
            escreve.insert(DBHelper.TABELA_PERSONAGENS, null, contentValues);
            Log.i("INFO", "Resgistro de personagem salvo com sucesso!");
        } catch (Exception e) {
            Log.i("INFO", "ERRO ao salvar resgistro de personagem! " + e.getMessage());
            return false;
        }

        return true;
    }

    public List<Personagem> listar(){

        List<Personagem> personagens = new ArrayList<>();

        String sql = "SELECT * FROM " +DBHelper.TABELA_PERSONAGENS+ ";";
        String sqlItens = "SELECT * FROM " +DBHelper.TABELA_ITENSRPG+ " WHERE item_personagem_id=?;";

        Cursor cursor = le.rawQuery(sql, null);

        while(cursor.moveToNext()){
            Personagem personagem = new Personagem();

            Long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            int idade = cursor.getInt(cursor.getColumnIndexOrThrow("idade"));
            String sexo = cursor.getString(cursor.getColumnIndexOrThrow("sexo"));
            String classe = cursor.getString(cursor.getColumnIndexOrThrow("classe"));
            String raca = cursor.getString(cursor.getColumnIndexOrThrow("raca"));

            List<ItemRPG> itens = new ArrayList<>();

            String[] args = {id.toString()};
            Cursor cursorItens = le.rawQuery(sqlItens, args);

            while (cursorItens.moveToNext()){
                ItemRPG itemRPG = new ItemRPG();

                Long idItem = cursorItens.getLong(cursorItens.getColumnIndexOrThrow("id"));
                String nomeItem = cursorItens.getString(cursorItens.getColumnIndexOrThrow("nome"));
                int qtditem = cursorItens.getInt(cursorItens.getColumnIndexOrThrow("qtditem"));
                Long item_personagem_id = cursorItens.getLong(cursorItens.getColumnIndexOrThrow("item_personagem_id"));

                itemRPG.setId(idItem);
                itemRPG.setNome(nomeItem);
                itemRPG.setQtdItem(qtditem);
                itemRPG.setItem_personagem_id(item_personagem_id);

                itens.add(itemRPG);
            }
            cursorItens.close();

            int nivel = cursor.getInt(cursor.getColumnIndexOrThrow("nivel"));
            int forca = cursor.getInt(cursor.getColumnIndexOrThrow("forca"));
            int constituicao = cursor.getInt(cursor.getColumnIndexOrThrow("constituicao"));
            int inteligencia = cursor.getInt(cursor.getColumnIndexOrThrow("inteligencia"));
            int destreza = cursor.getInt(cursor.getColumnIndexOrThrow("destreza"));
            int sabedoria = cursor.getInt(cursor.getColumnIndexOrThrow("sabedoria"));
            int carisma = cursor.getInt(cursor.getColumnIndexOrThrow("carisma"));
            int vida = cursor.getInt(cursor.getColumnIndexOrThrow("vida"));

            personagem.setId(id);
            personagem.setNome(nome);
            personagem.setIdade(idade);
            personagem.setSexo(sexo);
            personagem.setClasse(classe);
            personagem.setRaca(raca);
            personagem.setItens(itens);
            personagem.setNivel(nivel);
            personagem.setForca(forca);
            personagem.setConstituicao(constituicao);
            personagem.setInteligencia(inteligencia);
            personagem.setDestreza(destreza);
            personagem.setSabedoria(sabedoria);
            personagem.setCarisma(carisma);
            personagem.setVida(vida);

            personagens.add(personagem);
        }

        cursor.close();
        return personagens;
    }


    public boolean atualizar(Personagem personagem){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", personagem.getNome());
        contentValues.put("idade", personagem.getIdade());
        contentValues.put("sexo", personagem.getSexo());
        contentValues.put("classe", personagem.getClasse());
        contentValues.put("raca", personagem.getRaca());

        contentValues.put("nivel", personagem.getNivel());
        contentValues.put("forca", personagem.getForca());
        contentValues.put("constituicao", personagem.getConstituicao());
        contentValues.put("inteligencia", personagem.getInteligencia());
        contentValues.put("destreza", personagem.getDestreza());
        contentValues.put("sabedoria", personagem.getSabedoria());
        contentValues.put("carisma", personagem.getCarisma());
        contentValues.put("vida", personagem.getVida());

        try{
            String[] args = {personagem.getId().toString()};
            escreve.update(DBHelper.TABELA_PERSONAGENS, contentValues, "id=?", args);
            Log.i("INFO", "Resgistro de personagem atualizado com sucesso!");
        } catch (Exception e) {
            Log.i("INFO", "ERRO ao atualizar resgistro de personagem! " + e.getMessage());
            return false;
        }

        return true;
    }

    public boolean deletar(Personagem personagem){

        try{
            String[] args = {personagem.getId().toString()};
            escreve.delete(DBHelper.TABELA_ITENSRPG, "id=?", args);
            Log.i("INFO", "Resgistro de personagem apagado com sucesso!");
        } catch (Exception e) {
            Log.i("INFO", "ERRO ao apagar registro de personagem! " + e.getMessage());
            return false;
        }
        return true;
    }
    
}
