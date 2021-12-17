package com.imd.rpgmanager.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imd.rpgmanager.R;
import com.imd.rpgmanager.model.Personagem;

import java.util.List;

public class AdapterModPersonagem extends RecyclerView.Adapter<AdapterModPersonagem.MinhaViewHolder> {

    private List<Personagem> listaPersonagens;
    public AdapterModPersonagem(List<Personagem> lista){
        this.listaPersonagens = lista;
    }

    @NonNull
    @Override
    public MinhaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View elementoLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_personagem_lista_mod, parent, false);
        return new MinhaViewHolder(elementoLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MinhaViewHolder holder, int position) {

        Personagem personagem = listaPersonagens.get(position);

        holder.tvNome.setText(personagem.getNome());
        holder.tvClasse.setText(personagem.getClasse());

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MinhaViewHolder extends RecyclerView.ViewHolder{

        TextView tvNome;
        TextView tvClasse;

        public MinhaViewHolder(View itemView){
            super(itemView);

            tvNome = itemView.findViewById(R.id.cvtvNomePersonagem);
            tvClasse = itemView.findViewById(R.id.cvtvClassePersonagem);

        }

    }
}
