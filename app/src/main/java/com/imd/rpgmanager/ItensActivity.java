package com.imd.rpgmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imd.rpgmanager.dao.ItemRPGDAO;
import com.imd.rpgmanager.fragments.ItemListaFragment;
import com.imd.rpgmanager.model.ItemRPG;
import com.imd.rpgmanager.model.Personagem;

import java.util.List;

public class ItensActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private ItemListaFragment mItemListaFragment;

    EditText edNome;
    EditText edQuantidade;
    Button btnAdd;
    Button btnSalvar;
    Personagem personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens);

        Intent it = getIntent();
        personagem = (Personagem) it.getExtras().getSerializable("personagem");

        mFragmentManager = getSupportFragmentManager();
        mItemListaFragment = (ItemListaFragment) mFragmentManager
                .findFragmentById(R.id.fragmentTelaItens);

        edNome = findViewById(R.id.edNomeItem);
        edQuantidade = findViewById(R.id.edQuantidade);
        btnAdd = findViewById(R.id.btnAddItem);
        btnSalvar = findViewById(R.id.btnSalvarItens);

        atualizarItens(personagem);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edNome.getText().toString().isEmpty() || edQuantidade.getText().toString().isEmpty()){
                    return;
                }

                String nomeItem = edNome.getText().toString();
                int quantidadeItem = Integer.parseInt(edQuantidade.getText().toString());

                if(quantidadeItem < 1){
                    return;
                }

                ItemRPG itemNovo = new ItemRPG(nomeItem, quantidadeItem, personagem.getId());

                Log.i("INFO", "ID do dono: " + personagem.getId());
                ItemRPGDAO itemRPGDAO = new ItemRPGDAO(ItensActivity.this);
                itemRPGDAO.salvar(itemNovo);

                personagem.addItem(itemNovo);


                edNome.setText("");
                edQuantidade.setText("");

                atualizarItens(personagem);

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it.putExtra("personagemAtualizado", personagem);

                setResult(1, it);
                finish();
            }
        });

    }

    public void atualizarItens(Personagem personagem){
        mItemListaFragment.mostrarItensDoPersonagem(personagem);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("personagem", personagem);
    }


}