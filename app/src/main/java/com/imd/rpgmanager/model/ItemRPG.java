package com.imd.rpgmanager.model;

import java.io.Serializable;

public class ItemRPG implements Serializable {
    private String nome;
    private int qtdItem;

    public ItemRPG(String nome, int qtdItem) {
        this.nome = nome;
        this.qtdItem = qtdItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    @Override
    public String toString() {
        if(qtdItem>0)
            return String.format("%sx %s", qtdItem, nome);
        return nome;
    }
}
