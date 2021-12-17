package com.imd.rpgmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imd.rpgmanager.R;
import com.imd.rpgmanager.adapters.AdapterModPersonagem;
import com.imd.rpgmanager.model.ItemRPG;
import com.imd.rpgmanager.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class PersonagensListaModFragment extends Fragment {

    RecyclerView rvPersonagens;
    AdapterModPersonagem adapterModPersonagem;

    List<Personagem> mPersonagens = new ArrayList<Personagem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_personagem_lista_mod, container, false);

        rvPersonagens = layout.findViewById(R.id.rvListaPersonagem);

        mPersonagens = carregaPersonagens();

        adapterModPersonagem = new AdapterModPersonagem(mPersonagens);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvPersonagens.setLayoutManager(layoutManager);

        rvPersonagens.setHasFixedSize(true);
        rvPersonagens.setAdapter(adapterModPersonagem);


        return layout;
    }

    //Interface faz a comunicação entre FRAGMENTO (Personagem lista mod)
    // e Actividade (MainActivity)
    public interface AoClicarNoPersonagemMod{
        public void clicouNoPersonagemMod(Personagem personagem);
    }


    private List<Personagem> carregaPersonagens(){

        List<Personagem> personagens = new ArrayList<Personagem>();
        List<ItemRPG> itens = new ArrayList<ItemRPG>();
        itens.add(new ItemRPG("Claymore", 99));
        itens.add(new ItemRPG("Mirror Shield", 99));

        personagens.add(new Personagem("The Abyss Walker",500,"Paladino", itens));
        personagens.add(new Personagem("The Executor",37,"Ladino", itens));
        personagens.add(new Personagem("Dragon Slayer",34,"Guerreiro",itens));
        personagens.add(new Personagem("Chosen One",1,"Mago",itens));

        return personagens;
    }

    public void adicionar(Personagem personagem){
        mPersonagens.add(personagem);
        adapterModPersonagem.notifyDataSetChanged();
    }

    public void limpaBusca(){
        adapterModPersonagem = new AdapterModPersonagem(mPersonagens);
        rvPersonagens.setAdapter(adapterModPersonagem);
    }

}