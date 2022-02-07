package com.imd.rpgmanager.fragments;

import android.app.Activity;
import android.os.AsyncTask;
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
import com.imd.rpgmanager.dao.ItemRPGDAO;
import com.imd.rpgmanager.dao.PersonagemDAO;
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

            @Override
            public void pressionouPersonagem(int position) {

                Activity activity = getActivity();

                if(activity instanceof AoClicarEmPersonagemMod){
                    AoClicarEmPersonagemMod listener = (AoClicarEmPersonagemMod) activity;
                    listener.pressionouEmPersonagemMod(mPersonagens.get(position));
                }
            }
        });

        return layout;
    }

    public interface AoClicarEmPersonagemMod{
        void ciclouEmPersonagemMod(Personagem personagem);
        void pressionouEmPersonagemMod(Personagem personagem);
    }


    private List<Personagem> carregaPersonagens(){

        List<Personagem> personagens = new ArrayList<Personagem>();
        //List<ItemRPG> itens = new ArrayList<ItemRPG>();

        PersonagemDAO personagemDAO = new PersonagemDAO(getContext());
        personagens = personagemDAO.listar();

        /*itens.add(new ItemRPG("Claymore", 99));
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
        }*/

        return personagens;
    }

    public void adicionar(Personagem personagem){
        PersonagemDAO personagemDAO = new PersonagemDAO(getContext());
        ItemRPGDAO itemRPGDAO = new ItemRPGDAO(getContext());

        personagemDAO.salvar(personagem);

        List<ItemRPG> itens = personagem.getItens();

        limpaBusca();

        personagem = mPersonagens.get(mPersonagens.size()-1);

        for (ItemRPG itemRPG: itens) {
            itemRPG.setItem_personagem_id(personagem.getId());
            itemRPGDAO.salvar(itemRPG);
        }

        limpaBusca();
        //mPersonagens.add(personagem);
        adapterModPersonagem.notifyDataSetChanged();
    }

    public void atualizarPersonagem(Personagem personagem){

        for(Personagem pp: mPersonagens){
            if(pp.getId() == personagem.getId()){
                System.out.println(pp.getId());
                pp.setItens(personagem.getItens());
                pp.setNivel(personagem.getNivel());
                pp.setForca(personagem.getForca());
                pp.setConstituicao(personagem.getConstituicao());
                pp.setInteligencia(personagem.getInteligencia());
                pp.setDestreza(personagem.getDestreza());
                pp.setSabedoria(personagem.getSabedoria());
                pp.setCarisma(personagem.getCarisma());
                pp.setVida(personagem.getVida());
            }
        }

        //PersonagemDAO personagemDAO = new PersonagemDAO(getContext());
        //personagemDAO.atualizar(personagem);
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

        adapterModPersonagem.implementaAoClicarNoPersonagem(new AdapterModPersonagem.AoClicarNoPersonagem() {
            @Override
            public void clicouNoPersonagem(int position) {

                Activity activity = getActivity();

                if(activity instanceof AoClicarEmPersonagemMod){
                    AoClicarEmPersonagemMod listener = (AoClicarEmPersonagemMod) activity;
                    listener.ciclouEmPersonagemMod(personagemsEncontrados.get(position));
                }

            }

            @Override
            public void pressionouPersonagem(int position) {

                Activity activity = getActivity();

                if(activity instanceof AoClicarEmPersonagemMod){
                    AoClicarEmPersonagemMod listener = (AoClicarEmPersonagemMod) activity;
                    listener.pressionouEmPersonagemMod(personagemsEncontrados.get(position));
                }
            }
        });

        rvPersonagens.setAdapter(adapterModPersonagem);

    }

    public void limpaBusca(){
        PersonagemDAO personagemDAO = new PersonagemDAO(getContext());
        //mPersonagens = personagemDAO.listar();

        MinhaAsyncTask tarefa = new MinhaAsyncTask();
        tarefa.execute(personagemDAO);

        //adapterModPersonagem = new AdapterModPersonagem(mPersonagens);

        adapterModPersonagem.implementaAoClicarNoPersonagem(new AdapterModPersonagem.AoClicarNoPersonagem() {
            @Override
            public void clicouNoPersonagem(int position) {

                Activity activity = getActivity();

                if(activity instanceof AoClicarEmPersonagemMod){
                    AoClicarEmPersonagemMod listener = (AoClicarEmPersonagemMod) activity;
                    listener.ciclouEmPersonagemMod(mPersonagens.get(position));
                }

            }

            @Override
            public void pressionouPersonagem(int position) {

                Activity activity = getActivity();

                if(activity instanceof AoClicarEmPersonagemMod){
                    AoClicarEmPersonagemMod listener = (AoClicarEmPersonagemMod) activity;
                    listener.pressionouEmPersonagemMod(mPersonagens.get(position));
                }
            }
        });

        rvPersonagens.setAdapter(adapterModPersonagem);
    }

    class MinhaAsyncTask extends AsyncTask<PersonagemDAO, Void, List<Personagem>>{

        @Override
        protected List<Personagem> doInBackground(PersonagemDAO... personagemDAOS) {

            PersonagemDAO personagemDAO = personagemDAOS[0];
            List<Personagem> lista = null;

            try {
                lista = personagemDAO.listar();
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
            return lista;
        }

        @Override
        protected void onPostExecute(List<Personagem> personagems) {
            super.onPostExecute(personagems);
            adapterModPersonagem = new AdapterModPersonagem(personagems);
        }
    }

}