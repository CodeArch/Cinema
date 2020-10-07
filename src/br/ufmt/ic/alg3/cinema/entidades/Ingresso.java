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
    private Sala sala;
    private BigDecimal valor;
    private char tipo; // I para inteira e M para meia
    private Assento assentoReservado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Assento getAssentoReservado() {
        return assentoReservado;
    }

    public void setAssentoReservado(Assento assentoReservado) {
        this.assentoReservado = assentoReservado;
    }
    
    
    
}
