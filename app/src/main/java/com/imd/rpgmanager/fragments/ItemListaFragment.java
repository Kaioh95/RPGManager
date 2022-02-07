package com.imd.rpgmanager.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.imd.rpgmanager.R;
import com.imd.rpgmanager.dao.ItemRPGDAO;
import com.imd.rpgmanager.dao.PersonagemDAO;
import com.imd.rpgmanager.model.ClassesRPG;
import com.imd.rpgmanager.model.ItemRPG;
import com.imd.rpgmanager.model.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemListaFragment extends ListFragment {
    public static final String TAG_ITENS = "tagITens";
    public static final String ITENS = "itens";

    ClassesRPG mClasse;
    List<ItemRPG> mItens;
    ArrayAdapter<ItemRPG> mAdapter;

    public ItemListaFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mClasse = new ClassesRPG("Bárbaro");
        mItens = new ArrayList<ItemRPG>();

        mItens.add(new ItemRPG(mClasse.getDescricao(), 0));

        //(atividade, layout - simple_list_item_1, lista com dados)
        mAdapter = new ArrayAdapter<ItemRPG>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mItens
        );
        //para os dados para a ListView
        setListAdapter(mAdapter);

    }

    public void atualizar(String classeNome, int btnPrecionado){
        mItens = new ArrayList<ItemRPG>();

        mClasse = new ClassesRPG(classeNome);
        mItens.clear();

        if(btnPrecionado == 0){
            mItens.add(new ItemRPG(mClasse.getDescricao(), 0));
        }
        else{
            mItens = mClasse.getItens();
        }

        mAdapter = new ArrayAdapter<ItemRPG>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mItens
        );
        setListAdapter(mAdapter);
    }

    public void mostrarItensDoPersonagem(Personagem personagem){
        mItens = new ArrayList<ItemRPG>();
        mItens = personagem.getItens();

        mAdapter = new ArrayAdapter<ItemRPG>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mItens);
        setListAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ItemRPG itemSelecionado = mItens.get(position);

        new AlertDialog.Builder(getContext())
                .setTitle("Deletar")
                .setMessage("Isso irá DELETAR o item")
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ItemRPGDAO itemRPGDAO = new ItemRPGDAO(getContext());
                        if(itemRPGDAO.deletar(itemSelecionado)){
                            mostrarItensDoPersonagem();
                            //Toast.makeText(getContext(), "Personagem foi removido", Toast.LENGTH_SHORT).show();
                            //personagensListaModFragment.limpaBusca();
                        } else {
                            Toast.makeText(getContext(), "ERRO ao deletar personagem", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
            }
        }).setIcon(android.R.drawable.ic_delete)
                .show();
    }
}