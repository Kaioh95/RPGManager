package com.imd.rpgmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.imd.rpgmanager.model.Personagem;

import java.util.Random;

public class AtributosActivity extends AppCompatActivity {

    ImageView ivMochila;

    Button btnMaisNivel;

    Button btnMenosForca;
    Button btnMaisForca;

    Button btnMenosConstituicao;
    Button btnMaisConstituicao;

    Button btnMenosInteligencia;
    Button btnMaisInteligencia;

    Button btnMenosDestreza;
    Button btnMaisDestreza;

    Button btnMenosSabedoria;
    Button btnMaisSabedoria;

    Button btnMenosCarisma;
    Button btnMaisCarisma;

    Button btnMenosVida;
    Button btnMaisVida;

    Button btnResetar;
    Button btnConfirmar;
    Button btnVoltar;


    TextView tvPontosAtuais;
    TextView tvNivel;
    TextView tvForca;
    TextView tvConstituicao;
    TextView tvInteligencia;
    TextView tvDestreza;
    TextView tvSabedoria;
    TextView tvCarisma;
    TextView tvVida;

    TextView tvForcapb;
    TextView tvConstituicaopb;
    TextView tvInteligenciapb;
    TextView tvDestrezapb;
    TextView tvSabedoriapb;
    TextView tvCarismapb;
    TextView tvVidapb;

    ProgressBar pbForca;
    ProgressBar pbConstituicao;
    ProgressBar pbInteligencia;
    ProgressBar pbDestreza;
    ProgressBar pbSabedoria;
    ProgressBar pbCarisma;
    ProgressBar pbVida;

    int bonusForca = 0;
    int bonusConstituicao = 0;
    int bonusInteligencia = 0;
    int bonusDestreza = 0;
    int bonusSabedoria = 0;
    int bonusCarisma = 0;
    int bonusVida = 0;

    int dadoVida = 0;
    int VidaAtual = 0;
    int VidaMax = 0;

    int PONTOS_POR_NIVEL = 5;
    int NIVEL_MAX = 20;
    int PONTOS_MAX = 0; //baseado no nível do personagem quando upa

    Personagem personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributos);

        getSupportActionBar().hide();

        Intent it = getIntent();
        personagem = (Personagem) it.getExtras().getSerializable("personagem");

        ivMochila = findViewById(R.id.ivMochila);

        btnMaisNivel = findViewById(R.id.btnMaisNivel);

        btnMenosForca = findViewById(R.id.btnMenosForca);
        btnMaisForca = findViewById(R.id.btnMaisForca);

        btnMenosConstituicao = findViewById(R.id.btnMenosConstituicao);
        btnMaisConstituicao = findViewById(R.id.btnMaisConstituicao);

        btnMenosInteligencia = findViewById(R.id.btnMenosInteligencia);
        btnMaisInteligencia = findViewById(R.id.btnMaisInteligencia);

        btnMenosDestreza = findViewById(R.id.btnMenosDestreza);
        btnMaisDestreza = findViewById(R.id.btnMaisDestreza);

        btnMenosSabedoria = findViewById(R.id.btnMenosSabedoria);
        btnMaisSabedoria = findViewById(R.id.btnMaisSabedoria);

        btnMenosCarisma = findViewById(R.id.btnMenosCarisma);
        btnMaisCarisma = findViewById(R.id.btnMaisCarisma);

        btnMenosVida = findViewById(R.id.btnMenosVida);
        btnMaisVida = findViewById(R.id.btnMaisVida);

        btnConfirmar = findViewById(R.id.btnCorfirmar);
        btnResetar = findViewById(R.id.btnResetar);
        btnVoltar = findViewById(R.id.btnVoltar);

        //Valor dos atributos
        tvPontosAtuais = findViewById(R.id.tvPontosAtuais);
        tvNivel = findViewById(R.id.tvNivel);
        tvForca = findViewById(R.id.tvForca);
        tvConstituicao = findViewById(R.id.tvConstituicao);
        tvInteligencia = findViewById(R.id.tvInteligencia);
        tvDestreza = findViewById(R.id.tvDestreza);
        tvSabedoria = findViewById(R.id.tvSabedoria);
        tvCarisma = findViewById(R.id.tvCarisma);
        tvVida = findViewById(R.id.tvVida);

        tvPontosAtuais = findViewById(R.id.tvPontosAtuais);
        tvNivel = findViewById(R.id.tvNivel);
        tvForcapb = findViewById(R.id.tvForcapb);
        tvConstituicaopb = findViewById(R.id.tvConstituicaopb);
        tvInteligenciapb = findViewById(R.id.tvInteligenciapb);
        tvDestrezapb = findViewById(R.id.tvDestrezapb);
        tvSabedoriapb = findViewById(R.id.tvSabedoriapb);
        tvCarismapb = findViewById(R.id.tvCarismapb);
        tvVidapb = findViewById(R.id.tvVidapb);

        //Barras de atributos
        pbForca = findViewById(R.id.pbForca);
        pbConstituicao = findViewById(R.id.pbConstituicao);
        pbInteligencia = findViewById(R.id.pbInteligencia);
        pbDestreza = findViewById(R.id.pbDestreza);
        pbSabedoria = findViewById(R.id.pbSabedoria);
        pbCarisma = findViewById(R.id.pbCarisma);
        pbVida = findViewById(R.id.pbVida);

        tvNivel.setText(String.valueOf(personagem.getNivel()));

        tvForca.setText(String.valueOf(personagem.getForca()));
        tvConstituicao.setText(String.valueOf(personagem.getConstituicao()));
        tvInteligencia.setText(String.valueOf(personagem.getInteligencia()));
        tvDestreza.setText(String.valueOf(personagem.getDestreza()));
        tvSabedoria.setText(String.valueOf(personagem.getSabedoria()));
        tvCarisma.setText(String.valueOf(personagem.getCarisma()));

        if(Integer.parseInt(String.valueOf((personagem.getConstituicao() - 10) / 2)) > 0){
            VidaMax = dadoVida + personagem.getVida() + Integer.parseInt(String.valueOf((personagem.getConstituicao() - 10) / 2));
            personagem.setVida(dadoVida + personagem.getVida());
            tvVida.setText(String.valueOf(VidaMax));
        }else{
            tvVida.setText(String.valueOf(personagem.getVida()));
        }
        VidaMax = Integer.parseInt(String.valueOf(tvVida.getText()));
        VidaAtual = VidaMax;

        //Pontos iniciais
        if(personagem.getNivel() == 1
                && personagem.getForca() == 8
                && personagem.getConstituicao() == 8
                && personagem.getInteligencia() == 8
                && personagem.getDestreza() == 8
                && personagem.getSabedoria() == 8
                && personagem.getCarisma() == 8)
        {
            tvPontosAtuais.setText("20");
        }
        PONTOS_MAX = Integer.parseInt(String.valueOf(tvPontosAtuais.getText()));

        //Calcular bonus apenas para o textView ao lado do gráfico

        mostrarBonus();
        atualizarProgressBars();

        ivMochila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Mochila", Toast.LENGTH_SHORT).show();
                clicouMochila();
            }
        });

        btnMaisNivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvNivel.getText().toString()) <= NIVEL_MAX) {
                    tvNivel.setText(String.valueOf(Integer.parseInt(String.valueOf(tvNivel.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(PONTOS_POR_NIVEL + Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))));
                    PONTOS_MAX += PONTOS_POR_NIVEL;
                    dadoVida += new Random().nextInt(7)+1;
                }
            }
        });


        //Força
        btnMenosForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvForca.getText())) > personagem.getForca()){
                    tvForca.setText(String.valueOf(Integer.parseInt(String.valueOf(tvForca.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvForca.setText(String.valueOf(Integer.parseInt(String.valueOf(tvForca.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Constituicao
        btnMenosConstituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvConstituicao.getText())) > personagem.getConstituicao()){
                    tvConstituicao.setText(String.valueOf(Integer.parseInt(String.valueOf(tvConstituicao.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisConstituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvConstituicao.setText(String.valueOf(Integer.parseInt(String.valueOf(tvConstituicao.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Inteligência
        btnMenosInteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvInteligencia.getText())) > personagem.getInteligencia()){

                    tvInteligencia.setText(String.valueOf(Integer.parseInt(String.valueOf(tvInteligencia.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisInteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvInteligencia.setText(String.valueOf(Integer.parseInt(String.valueOf(tvInteligencia.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Destreza
        btnMenosDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvDestreza.getText())) > personagem.getDestreza()){
                    tvDestreza.setText(String.valueOf(Integer.parseInt(String.valueOf(tvDestreza.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvDestreza.setText(String.valueOf(Integer.parseInt(String.valueOf(tvDestreza.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Sabedoria
        btnMenosSabedoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvSabedoria.getText())) > personagem.getSabedoria()){
                    tvSabedoria.setText(String.valueOf(Integer.parseInt(String.valueOf(tvSabedoria.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisSabedoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvSabedoria.setText(String.valueOf(Integer.parseInt(String.valueOf(tvSabedoria.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Carisma
        btnMenosCarisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvCarisma.getText())) > personagem.getCarisma()){
                    tvCarisma.setText(String.valueOf(Integer.parseInt(String.valueOf(tvCarisma.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisCarisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvCarisma.setText(String.valueOf(Integer.parseInt(String.valueOf(tvCarisma.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Vida
        btnMenosVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvVida.getText())) > 0){
                    tvVida.setText(String.valueOf(Integer.parseInt(String.valueOf(tvVida.getText())) - 1));
                }
            }
        });
        btnMaisVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvVida.getText())) < VidaMax){
                    tvVida.setText(String.valueOf(Integer.parseInt(String.valueOf(tvVida.getText())) + 1));
                }else{
                    Toast.makeText(getApplicationContext(), "Limite de vida atingido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Botão para resetar os atributos
        btnResetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvNivel.getText())) == 0) {
                    Toast.makeText(getApplicationContext(), "Nada para resetar", Toast.LENGTH_SHORT).show();
                } else {
                    new AlertDialog.Builder(AtributosActivity.this)
                            .setTitle("Resetar")
                            .setMessage("Isso irá resetar seu nível e todos os seus pontos distribuídos")
                            .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    VidaMax = 0;

                                    personagem.setNivel(1);
                                    personagem.setForca(8);
                                    personagem.setConstituicao(8);
                                    personagem.setInteligencia(8);
                                    personagem.setDestreza(8);
                                    personagem.setSabedoria(8);
                                    personagem.setCarisma(8);


                                    int dVida = new Random().nextInt(7)+1;
                                    personagem.setVida(8 + dVida);

                                    System.out.println(personagem.getVida());

                                    tvPontosAtuais.setText("20");
                                    PONTOS_MAX = 20;
                                    tvNivel.setText("1");
                                    tvForca.setText(String.valueOf(personagem.getForca()));
                                    tvConstituicao.setText(String.valueOf(personagem.getConstituicao()));
                                    tvInteligencia.setText(String.valueOf(personagem.getInteligencia()));
                                    tvDestreza.setText(String.valueOf(personagem.getDestreza()));
                                    tvSabedoria.setText(String.valueOf(personagem.getSabedoria()));
                                    tvCarisma.setText(String.valueOf(personagem.getCarisma()));

                                    VidaMax += personagem.getVida();
                                    tvVida.setText(String.valueOf(VidaMax));
                                    personagem.setVida(VidaMax);

                                    mostrarBonus();
                                    atualizarProgressBars();
                                }
                            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    }).setIcon(android.R.drawable.ic_delete)
                            .show();
                }
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    Toast.makeText(getApplicationContext(), "Ainda há pontos para gastar", Toast.LENGTH_SHORT).show();
                }else{
                    personagem.setNivel(Integer.parseInt((String) tvNivel.getText()));
                    personagem.setForca(Integer.parseInt((String) tvForca.getText()));
                    personagem.setConstituicao(Integer.parseInt((String) tvConstituicao.getText()));
                    personagem.setInteligencia(Integer.parseInt((String) tvInteligencia.getText()));
                    personagem.setDestreza(Integer.parseInt((String) tvDestreza.getText()));
                    personagem.setSabedoria(Integer.parseInt((String) tvSabedoria.getText()));
                    personagem.setCarisma(Integer.parseInt((String) tvCarisma.getText()));
                    PONTOS_MAX = 0;

                    if(Integer.parseInt(String.valueOf((personagem.getConstituicao() - 10) / 2)) > 0){
                        VidaMax = dadoVida + personagem.getVida() + Integer.parseInt(String.valueOf((personagem.getConstituicao() - 10) / 2));
                        personagem.setVida(dadoVida + personagem.getVida());
                    }else if(dadoVida > 0){
                        VidaMax = dadoVida + personagem.getVida();
                        personagem.setVida(dadoVida + personagem.getVida());
                    }else{
                        personagem.setVida(VidaMax);
                    }

                    mostrarBonus();
                    atualizarProgressBars();
                    Toast.makeText(getApplicationContext(), "Informações Salvas", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it.putExtra("personagemAtualizado", personagem);
                setResult(1, it);
                finish();
            }
        });
    }



    private void mostrarBonus(){
        switch (personagem.getRaca()){
            case "Anão":
                bonusForca = 2;
                break;
            case "Elfo":
                bonusDestreza = 2;
                break;
            case "Halfing":
                bonusDestreza = 2;
                break;
            case "Humano":
                bonusForca = 1;
                bonusConstituicao = 1;
                bonusInteligencia = 1;
                bonusDestreza = 1;
                bonusSabedoria = 1;
                bonusCarisma = 1;
                break;
            case "Draconato":
                bonusCarisma = 1;
                bonusForca = 1;
                break;
            case "Gnomo":
                bonusInteligencia = 2;
                break;
            case "Meio-elfo":
                bonusCarisma = 2;
                bonusDestreza = 1;
                bonusInteligencia = 1;
                break;
            case "Meio-orc":
                bonusCarisma = 2;
                bonusDestreza = 1;
                bonusForca = 1;
                break;
            case "Tiefling":
                bonusInteligencia = 1;
                bonusCarisma = 2;
                break;
            default:
                throw new IllegalArgumentException("Raça Inválida!");
        }
        if (Integer.parseInt(String.valueOf(tvForca.getText())) > 10){
            bonusForca += Integer.valueOf((Integer.parseInt(String.valueOf(tvForca.getText())) - 10) / 2);
        }
        if (Integer.parseInt(String.valueOf(tvConstituicao.getText())) > 10){
            bonusConstituicao += Integer.valueOf((Integer.parseInt(String.valueOf(tvConstituicao.getText())) - 10) / 2);
            bonusVida += Integer.parseInt(String.valueOf((personagem.getConstituicao() - 10) / 2));
        }
        if (Integer.parseInt(String.valueOf(tvInteligencia.getText())) > 10){
            bonusInteligencia += Integer.valueOf((Integer.parseInt(String.valueOf(tvInteligencia.getText())) - 10) / 2);
        }
        if (Integer.parseInt(String.valueOf(tvDestreza.getText())) > 10){
            bonusDestreza += Integer.valueOf((Integer.parseInt(String.valueOf(tvDestreza.getText())) - 10) / 2);
        }
        if (Integer.parseInt(String.valueOf(tvSabedoria.getText())) > 10){
            bonusSabedoria += Integer.valueOf((Integer.parseInt(String.valueOf(tvSabedoria.getText())) - 10) / 2);
        }
        if (Integer.parseInt(String.valueOf(tvCarisma.getText())) > 10){
            bonusCarisma += Integer.valueOf((Integer.parseInt(String.valueOf(tvCarisma.getText())) - 10) / 2);
        }

        tvForcapb.setText("Força (+" + bonusForca +")");
        tvConstituicaopb.setText("Constituição (+" + bonusConstituicao +")");
        tvInteligenciapb.setText("Inteligência (+" + bonusInteligencia +")");
        tvDestrezapb.setText("Destreza (+" + bonusDestreza +")");
        tvSabedoriapb.setText("Sabedoria (+" + bonusSabedoria +")");
        tvCarismapb.setText("Carisma (+" + bonusCarisma +")");
        tvVidapb.setText("Vida (+" + bonusVida +") max("+ VidaMax +")");

        bonusForca = 0;
        bonusConstituicao = 0;
        bonusInteligencia = 0;
        bonusDestreza = 0;
        bonusSabedoria = 0;
        bonusCarisma = 0;
        bonusVida = 0;
        dadoVida = 0;
    }

    public void atualizarProgressBars(){
        pbForca.setProgress(Integer.parseInt(String.valueOf(tvForca.getText())));
        pbConstituicao.setProgress(Integer.parseInt(String.valueOf(tvConstituicao.getText())));
        pbInteligencia.setProgress(Integer.parseInt(String.valueOf(tvInteligencia.getText())));
        pbDestreza.setProgress(Integer.parseInt(String.valueOf(tvDestreza.getText())));
        pbSabedoria.setProgress(Integer.parseInt(String.valueOf(tvSabedoria.getText())));
        pbCarisma.setProgress(Integer.parseInt(String.valueOf(tvCarisma.getText())));
        pbVida.setMax(VidaMax);
        pbVida.setProgress(Integer.parseInt(String.valueOf(tvVida.getText())));

    }

    public void clicouMochila(){
        Intent it = new Intent(this, ItensActivity.class);
        it.putExtra("personagem", personagem);
        startActivityForResult(it, 1);
    }
}