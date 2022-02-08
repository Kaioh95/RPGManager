package com.imd.rpgmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.imd.rpgmanager.adapters.AdapterModPersonagem;
import com.imd.rpgmanager.dao.ItemRPGDAO;
import com.imd.rpgmanager.dao.PersonagemDAO;
import com.imd.rpgmanager.fragments.ItemListaFragment;
import com.imd.rpgmanager.fragments.PersonagensListaModFragment;
import com.imd.rpgmanager.model.ItemRPG;
import com.imd.rpgmanager.model.Personagem;

import java.util.List;

public class ItensActivity extends AppCompatActivity implements ItemListaFragment.AoClicarEmItem{

    private FragmentManager mFragmentManager;
    private ItemListaFragment mItemListaFragment;

    EditText edNome;
    EditText edQuantidade;
    Button btnAdd;
    Button btnSalvar;
    Personagem personagem;

    LinearLayout itenslayout;

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

        itenslayout = findViewById(R.id.itenslayout);

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


    @Override
    public void clicouEmItem(ItemRPG item) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(ItensActivity.this);

        dialog.setTitle("Confirmar Exclusão");
        dialog.setMessage("Deseja excluir o item: " + item.getNome() + " ?");

        dialog.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ItemRPGDAO itemRPGDAO = new ItemRPGDAO(getApplicationContext());
                if(itemRPGDAO.deletar(item)){
                    atualizarItens(personagem);

                    Snackbar.make(itenslayout, "Item removido!", Snackbar.LENGTH_SHORT
                    ).setAction("Desfazer?", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            itemRPGDAO.salvar(item);
                            atualizarItens(personagem);
                        }
                    }).setActionTextColor(getResources().getColor(R.color.design_default_color_error)).show();

                } else {
                    Toast.makeText(getApplicationContext(), "ERRO ao deletar item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.setNegativeButton("Não", null);
        dialog.setIcon(android.R.drawable.ic_delete);

        dialog.create();
        dialog.show();
    }

}