/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.utils;

import br.ufmt.ic.alg3.cinema.persistencia.AssentoDAO;
import br.ufmt.ic.alg3.cinema.persistencia.CaixaDAO;
import br.ufmt.ic.alg3.cinema.persistencia.FilmeDAO;
import br.ufmt.ic.alg3.cinema.persistencia.FuncionarioDAO;
import br.ufmt.ic.alg3.cinema.persistencia.IngressoDAO;
import br.ufmt.ic.alg3.cinema.persistencia.SalaDAO;
import br.ufmt.ic.alg3.cinema.persistencia.SessaoDAO;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.AssentoDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.CaixaDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.FilmeDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.IngressoDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.SalaDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.SessaoDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.postgresql.FuncionarioDAOImplPostgreSQL;

/**
 *
 * @author Henrique
 */
public class DAOFactory {
    
    public static AssentoDAO createAssentoDAO() {
        return new AssentoDAOImplArq();
    }
    
    public static CaixaDAO createCaixaDAO() {
        return new CaixaDAOImplArq();
    }
    
    public static FilmeDAO createFilmeDAO() {
        return new FilmeDAOImplArq();
    }

    public static FuncionarioDAO createFuncionarioDAO() {
        return new FuncionarioDAOImplPostgreSQL();
    }
 
    public static IngressoDAO createIngressoDAO() {
        return new IngressoDAOImplArq();
    }
    
    public static SalaDAO createSalaDAO() {
        return new SalaDAOImplArq();
    }
    
    public static SessaoDAO createSessaoDAO() {
        return new SessaoDAOImplArq();
    }
    
}
