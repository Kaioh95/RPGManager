package com.imd.rpgmanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Personagem implements Serializable {
    private Long id;
    private String nome;
    private int idade;
    private String sexo;
    private String classe;
    private String raca;
    private List<ItemRPG> itens;

    private int nivel = 1;
    private int forca = 0;
    private int constituicao = 0;
    private int inteligencia = 0;
    private int destreza = 0;
    private int sabedoria = 0;
    private int carisma = 0;
    private int vida = 0;

    public Personagem(){ }

    public Personagem(String nome, int idade, String sexo,String classe, String raca, List<ItemRPG> itens) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.classe = classe;
        this.raca = raca;
        this.itens = new ArrayList<ItemRPG>(itens);
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId() {
        return id;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public List<ItemRPG> getItens() {
        return itens;
    }

    public void setItens(List<ItemRPG> itens) {
        this.itens = itens;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void addItem(ItemRPG item){
        this.itens.add(item);
    }
}
