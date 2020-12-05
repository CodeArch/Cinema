/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.postgresql;

import br.ufmt.ic.alg3.cinema.entidades.Assento;
import br.ufmt.ic.alg3.cinema.entidades.Ingresso;
import br.ufmt.ic.alg3.cinema.persistencia.AssentoDAO;
import br.ufmt.ic.alg3.cinema.persistencia.IngressoDAO;
import br.ufmt.ic.alg3.cinema.persistencia.SessaoDAO;
import br.ufmt.ic.alg3.cinema.utils.DAOFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrique
 */
public class IngressoDAOImplPostgreSQL implements IngressoDAO {

    private Connection con;
    
    private AssentoDAO assentoDAO = DAOFactory.createAssentoDAO();
    private SessaoDAO sessaoDAO = DAOFactory.createSessaoDAO();
    
    private void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema", "user", "user");
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Ingresso ingresso) {
        conectar();
        
        String sql =
                "INSERT INTO ingresso (valor, meia, sessao, assento)\n" +
                "VALUES (?, ?, ?, ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setObject(1, ingresso.getValor());
            ps.setBoolean(2, ingresso.getMeia());
            ps.setInt(3, ingresso.getSessao().getId());
            ps.setInt(4, ingresso.getAssento().getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public void editar(Ingresso ingresso) {
        conectar();
        
        String sql = 
                "UPDATE \n" +
                "	ingresso\n" +
                "SET\n" +
                "	valor = ?,\n" +
                "	meia = ?,\n" +
                "	sessao = ?,\n" +
                "	assento = ?\n" +
                "WHERE\n" +
                "	id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setObject(1, ingresso.getValor());
            ps.setBoolean(2, ingresso.getMeia());
            ps.setInt(3, ingresso.getSessao().getId());
            ps.setInt(4, ingresso.getAssento().getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public boolean remover(int id) {
        conectar();
        
        String sql = "DELETE FROM ingresso WHERE id = " + id + ";";
        
        try {
            con.createStatement().execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        
        return false;
    }

    @Override
    public Ingresso getById(int id) {
        Ingresso i = null;
        
        conectar();
        
        String sql = 
                "SELECT\n" +
                "	ingresso.id,\n" +
                "	ingresso.valor,\n" +
                "	ingresso.meia,\n" +
                "	ingresso.assento,\n" +
                "	ingresso.sessao\n" +
                "FROM\n" +
                "	ingresso\n" +
                "WHERE \n" +
                "	ingresso.id = " + id + ";";
       
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                i = new Ingresso();
                
                i.setId(rs.getInt("id"));
                i.setValor((BigDecimal) rs.getObject("valor"));
                i.setMeia(rs.getBoolean("meia"));
                i.setAssento(assentoDAO.getById(rs.getInt("assento")));
                i.setSessao(sessaoDAO.getById(rs.getInt("sessao")));
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return i;
    }

    @Override
    public Ingresso getByAssento(Assento assento) {
        Ingresso i = null;
        
        conectar();
        
        String sql =
                "SELECT\n" +
                "	ingresso.id,\n" +
                "	ingresso.valor,\n" +
                "	ingresso.meia,\n" +
                "	ingresso.sessao,\n" +
                "	ingresso.assento\n" +
                "FROM	\n" +
                "	ingresso\n" +
                "INNER JOIN\n" +
                "	assento\n" +
                "ON\n" +
                "	assento.id = ingresso.assento\n" +
                "WHERE \n" +
                "	assento.id = " + assento.getId() + ";";
        
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                i = new Ingresso();
                
                i.setId(rs.getInt("id"));
                i.setMeia(rs.getBoolean("meia"));
                i.setValor((BigDecimal) rs.getObject("valor"));
                i.setSessao(sessaoDAO.getById(rs.getInt("sessao")));
                i.setAssento(assentoDAO.getById(rs.getInt("assento")));
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return i;
    }

    @Override
    public List<Ingresso> listar() {
        List<Ingresso> lista = new ArrayList<>();

        conectar();
        
        String sql = "SELECT * FROM ingresso;";
        
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Ingresso i = new Ingresso();
                
                i.setId(rs.getInt("id"));
                i.setValor((BigDecimal) rs.getObject("valor"));
                i.setMeia(rs.getBoolean("meia"));
                i.setAssento(assentoDAO.getById(rs.getInt("assento")));
                i.setSessao(sessaoDAO.getById(rs.getInt("sessao")));
                
                lista.add(i);
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return lista;
    }
    
}
