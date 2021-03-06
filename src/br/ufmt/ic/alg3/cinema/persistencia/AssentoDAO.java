/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia;

import br.ufmt.ic.alg3.cinema.entidades.Assento;
import br.ufmt.ic.alg3.cinema.entidades.Sala;
import java.util.List;

/**
 *
 * @author henrique
 */
public interface AssentoDAO {
    
    public void inserir(Assento assento);
    
    public void editar(Assento assento);
    
    public boolean remover(int id);
    
    public boolean getAssentoOcupado(int id);
    
    public Assento getById(int id);
    
    public List<Assento> getBySala(Sala sala);
    
    public List<Assento> listar();
    
}
