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
    
    /**
     * Insere uma nova Sala
     * @param sala
     * @return 
     * O ID gerado para o novo registro. <br>
     * Em arquivo, o valor é o mesmo que o ID fornecido. <br>
     * Em banco de dados, o valor é equivalente ao retorno da função lastval(). <br>
     * -1 caso não tenha sido possível retornar o valor correto.
     * 
     */
    public int inserir(Sala sala);
    
    public void editar (Sala sala);
    
    public boolean remover(int id);
    
    public Sala getById(int id);
    
    public List<Sala> listar();
    
}
