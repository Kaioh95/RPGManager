package com.imd.rpgmanager.model;

import java.util.List;

public class Personagem {
    private String nome;
    private int idade;
    private String classe;
    private List<ItemRPG> itens;

    public Personagem(String nome, int idade, String classe, List<ItemRPG> itens) {
        this.nome = nome;
        this.idade = idade;
        this.classe = classe;
        this.itens = itens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public List<ItemRPG> getItens() {
        return itens;
    }

    public void setItens(List<ItemRPG> itens) {
        this.itens = itens;
    }
}
