/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia;

import br.ufmt.ic.alg3.cinema.entidades.Filme;
import java.util.List;

/**
 *
 * @author henrique
 */
public interface FilmeDAO {
    
    public void inserir(Filme filme);
    
    public void editar(Filme filme);
    
    public boolean remover(int id);
    
    public Filme getById(int id);
    
    public List<Filme> listar();
    
}
