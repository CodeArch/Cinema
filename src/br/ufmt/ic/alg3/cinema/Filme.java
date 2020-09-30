/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema;

/**
 *
 * @author henrique
 */
public class Filme {
    
    private int id;
    private String nome;
    private int duracao; // Em minutos
    private boolean filme3d; // 0 para 2D e 1 para 3D

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public boolean isFilme3d() {
        return filme3d;
    }

    public void setFilme3d(boolean filme3d) {
        this.filme3d = filme3d;
    }
    
    
}
