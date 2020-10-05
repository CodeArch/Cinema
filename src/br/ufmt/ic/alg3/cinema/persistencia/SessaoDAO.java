/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia;

import br.ufmt.ic.alg3.cinema.entidades.Sessao;
import java.util.List;

/**
 *
 * @author henrique
 */
public interface SessaoDAO {
    
    public void inserir(Sessao sessao);
    
    public void editar(Sessao sessao);
    
    public boolean remover(int id);

    public Sessao getById(int id);
    
    public List<Sessao> listar();
    
}
