/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia;

import br.ufmt.ic.alg3.cinema.entidades.Assento;
import br.ufmt.ic.alg3.cinema.entidades.Ingresso;
import java.util.List;

/**
 *
 * @author henrique
 */
public interface IngressoDAO {
    
    public void inserir(Ingresso ingresso);
    
    public void editar(Ingresso ingresso);
    
    public boolean remover(int id);
    
    public Ingresso getById(int id);
    
    public Ingresso getByAssento(Assento assento);
    
    public List<Ingresso> listar();
    
}
