/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia;

import br.ufmt.ic.alg3.cinema.entidades.Sala;
import java.util.List;

/**
 *
 * @author henrique
 */
public interface SalaDAO {
    
    public void inserir(Sala sala);
    
    public void editar (Sala sala);
    
    public boolean remover(int id);
    
    public Sala getById(int id);
    
    public List<Sala> listar();
    
}