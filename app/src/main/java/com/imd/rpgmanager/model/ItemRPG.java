package com.imd.rpgmanager.model;

import java.io.Serializable;

public class ItemRPG implements Serializable {

    private Long id;
    private String nome;
    private int qtditem;
    private Long item_personagem_id;

    public ItemRPG(){

    }

    public ItemRPG(String nome, int qtdItem) {
        this.nome = nome;
        this.qtditem = qtdItem;
    }

    public ItemRPG(String nome, int qtdItem, Long ip_id) {
        this.nome = nome;
        this.qtditem = qtdItem;
        this.item_personagem_id = ip_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdItem() {
        return qtditem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtditem = qtdItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItem_personagem_id() {
        return item_personagem_id;
    }

    public void setItem_personagem_id(Long item_personagem_id) {
        this.item_personagem_id = item_personagem_id;
    }

    @Override
    public String toString() {
        if(qtditem>0)
            return String.format("%sx %s", qtditem, nome);
        return nome;
    }
}
