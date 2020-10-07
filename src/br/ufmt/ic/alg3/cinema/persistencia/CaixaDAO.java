/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia;

import br.ufmt.ic.alg3.cinema.entidades.Caixa;
import java.util.List;

/**
 *
 * @author henrique
 */
public interface CaixaDAO {
    
    public void inserir(Caixa caixa);
    
    public void editar(Caixa caixa);
    
    public boolean remover(int id);
    
    public Caixa getById(int id);
    
    public List<Caixa> listar();
    
}
