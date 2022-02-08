package com.imd.rpgmanager.fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.imd.rpgmanager.R;
import com.imd.rpgmanager.dao.ItemRPGDAO;
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
        //ItemRPGDAO itemRPGDAO = new ItemRPGDAO(getContext());
        //mItens = itemRPGDAO.listarPorDono(personagem.getId());

        ListaItensTask tarefa = new ListaItensTask();
        tarefa.execute(personagem.getId());

        /*mAdapter = new ArrayAdapter<ItemRPG>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mItens);
        setListAdapter(mAdapter);*/
    }

    class ListaItensTask extends AsyncTask<Long, Void, List<ItemRPG>> {

        @Override
        protected List<ItemRPG> doInBackground(Long... longs) {

            Long idDono = longs[0];

            ItemRPGDAO itemRPGDAO = new ItemRPGDAO(getContext());
            List<ItemRPG> lista = null;

            try{
                lista = itemRPGDAO.listarPorDono(idDono);
                mItens = lista;
            }catch (Exception e){
                e.printStackTrace();
            }

            return lista;
        }

        @Override
        protected void onPostExecute(List<ItemRPG> itemRPGS) {
            super.onPostExecute(itemRPGS);

            mAdapter = new ArrayAdapter<ItemRPG>(
                    getActivity(),
                    android.R.layout.simple_list_item_1,
                    itemRPGS);
            setListAdapter(mAdapter);
        }
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();

        if(activity instanceof AoClicarEmItem){
            ItemRPG item = (ItemRPG) l.getItemAtPosition(position);

            AoClicarEmItem listener = (AoClicarEmItem) activity;
            listener.clicouEmItem(item);
        }
    }

    public interface AoClicarEmItem{
        void clicouEmItem(ItemRPG item);
    }

}