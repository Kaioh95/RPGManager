package com.imd.rpgmanager.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        adapterModPersonagem.implementaAoClicarNoPersonagem(new AdapterModPersonagem.AoClicarNoPersonagem() {
            @Override
            public void clicouNoPersonagem(int position) {

                Activity activity = getActivity();

                if(activity instanceof AoClicarEmPersonagemMod){
                    AoClicarEmPersonagemMod listener = (AoClicarEmPersonagemMod) activity;
                    listener.ciclouEmPersonagemMod(mPersonagens.get(position));
                }

            }
        });

        return layout;
    }

    public interface AoClicarEmPersonagemMod{
        void ciclouEmPersonagemMod(Personagem personagem);
    }


    private List<Personagem> carregaPersonagens(){

        List<Personagem> personagens = new ArrayList<Personagem>();
        List<ItemRPG> itens = new ArrayList<ItemRPG>();
        itens.add(new ItemRPG("Claymore", 99));
        itens.add(new ItemRPG("Mirror Shield", 99));

        personagens.add(new Personagem("The Abyss Walker",500, "Indefinido","Paladino", "Draconato",itens));
        personagens.add(new Personagem("The Executor",37, "Indefinido","Ladino", "Draconato", itens));
        personagens.add(new Personagem("Dragon Slayer",34,"Indefinido", "Guerreiro","Draconato", itens));
        personagens.add(new Personagem("Chosen One",1,"", "Mago","Humano", itens));

        for (Personagem personagem: personagens){
            personagem.setNivel(10);
            personagem.setForca(20);
            personagem.setConstituicao(20);
            personagem.setInteligencia(20);
            personagem.setDestreza(20);
            personagem.setSabedoria(20);
            personagem.setCarisma(20);
            personagem.setVida(20);
        }

        return personagens;
    }

    public void adicionar(Personagem personagem){
        mPersonagens.add(personagem);
        adapterModPersonagem.notifyDataSetChanged();
    }

    public void buscar(String s){

        if(s == null || s.trim().equals("")){
            limpaBusca();
            return;
        }

        List<Personagem> personagemsEncontrados = new ArrayList<Personagem>(mPersonagens);

        for(int i = personagemsEncontrados.size()-1; i >= 0; i--){
            Personagem personagem = personagemsEncontrados.get(i);

            if(!personagem.getNome().toUpperCase().contains(s.toUpperCase())){
                personagemsEncontrados.remove(personagem);
            }
        }
        //Configurar o adapter
        adapterModPersonagem = new AdapterModPersonagem(personagemsEncontrados);
        rvPersonagens.setAdapter(adapterModPersonagem);

    }

    public void limpaBusca(){
        adapterModPersonagem = new AdapterModPersonagem(mPersonagens);
        rvPersonagens.setAdapter(adapterModPersonagem);
    }

}