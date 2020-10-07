/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia;

import br.ufmt.ic.alg3.cinema.entidades.Funcionario;
import java.util.List;

/**
 *
 * @author henrique
 */
public interface FuncionarioDAO {
    
    public void inserir(Funcionario funcionario);
    
    public void editar(Funcionario funcionario);
    
    public boolean remover(int id);
    
    public Funcionario getById(int id);
    
    public List<Funcionario> listar();
    
}
