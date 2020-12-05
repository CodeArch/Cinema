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
import br.ufmt.ic.alg3.cinema.persistencia.postgresql.AssentoDAOImplPostgreSQL;
import br.ufmt.ic.alg3.cinema.persistencia.postgresql.CaixaDAOImplPostgreSQL;
import br.ufmt.ic.alg3.cinema.persistencia.postgresql.FilmeDAOImplPostgreSQL;
import br.ufmt.ic.alg3.cinema.persistencia.postgresql.FuncionarioDAOImplPostgreSQL;
import br.ufmt.ic.alg3.cinema.persistencia.postgresql.IngressoDAOImplPostgreSQL;
import br.ufmt.ic.alg3.cinema.persistencia.postgresql.SalaDAOImplPostgreSQL;
import br.ufmt.ic.alg3.cinema.persistencia.postgresql.SessaoDAOImplPostgreSQL;

/**
 *
 * @author Henrique
 */
public class DAOFactory {
    
    public static AssentoDAO createAssentoDAO() {
        return new AssentoDAOImplPostgreSQL();
    }
    
    public static CaixaDAO createCaixaDAO() {
        return new CaixaDAOImplPostgreSQL();
    }
    
    public static FilmeDAO createFilmeDAO() {
        return new FilmeDAOImplPostgreSQL();
    }

    public static FuncionarioDAO createFuncionarioDAO() {
        return new FuncionarioDAOImplPostgreSQL();
    }
 
    public static IngressoDAO createIngressoDAO() {
        return new IngressoDAOImplPostgreSQL();
    }
    
    public static SalaDAO createSalaDAO() {
        return new SalaDAOImplPostgreSQL();
    }
    
    public static SessaoDAO createSessaoDAO() {
        return new SessaoDAOImplPostgreSQL();
    }
    
}
