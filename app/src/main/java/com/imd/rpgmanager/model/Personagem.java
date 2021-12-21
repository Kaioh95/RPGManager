package com.imd.rpgmanager.model;

import java.io.Serializable;
import java.util.List;

public class Personagem implements Serializable {
    private String nome;
    private int idade;
    private String sexo;
    private String classe;
    private String raca;
    private transient List<ItemRPG> itens;

    private int Nivel = 1;
    private int Forca = 0;
    private int Constituicao = 0;
    private int Inteligencia = 0;
    private int Destreza = 0;
    private int Sabedoria = 0;
    private int Carisma = 0;
    private int Vida = 0;

    public Personagem(){ }

    public Personagem(String nome, int idade, String sexo,String classe, String raca, List<ItemRPG> itens) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.classe = classe;
        this.raca = raca;
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
        return Nivel;
    }

    public void setNivel(int nivel) {
        Nivel = nivel;
    }

    public int getForca() {
        return Forca;
    }

    public void setForca(int forca) {
        Forca = forca;
    }

    public int getConstituicao() {
        return Constituicao;
    }

    public void setConstituicao(int constituicao) {
        Constituicao = constituicao;
    }

    public int getInteligencia() {
        return Inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        Inteligencia = inteligencia;
    }

    public int getDestreza() {
        return Destreza;
    }

    public void setDestreza(int destreza) {
        Destreza = destreza;
    }

    public int getSabedoria() {
        return Sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        Sabedoria = sabedoria;
    }

    public int getCarisma() {
        return Carisma;
    }

    public void setCarisma(int carisma) {
        Carisma = carisma;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }
}
