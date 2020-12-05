/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author henrique
 */
public class Ingresso implements Serializable {
 
    private int id;
    private BigDecimal valor;
    private boolean meia; 
    private Sessao sessao;
    private Assento assento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean getMeia() {
        return meia;
    }

    public void setMeia(boolean meia) {
        this.meia = meia;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }
    
    
    
}
