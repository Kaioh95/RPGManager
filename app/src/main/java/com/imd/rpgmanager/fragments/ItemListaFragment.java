package com.imd.rpgmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.imd.rpgmanager.R;
import com.imd.rpgmanager.model.ClassesRPG;
import com.imd.rpgmanager.model.ItemRPG;
import com.imd.rpgmanager.model.Personagem;

import java.util.ArrayList;
import java.util.List;

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

}