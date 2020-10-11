/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.entidades;

import java.io.Serializable;

/**
 *
 * @author henrique
 */
public class Sala implements Serializable {
    
    private int id;
    private Assento assentos[];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Assento[] getAssentos() {
        return assentos;
    }

    public void setAssentos(Assento[] assentos) {
        this.assentos = assentos;
    }
    
    
    
}
