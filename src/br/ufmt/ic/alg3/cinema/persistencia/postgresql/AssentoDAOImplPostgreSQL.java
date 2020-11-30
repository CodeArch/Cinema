/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.postgresql;

import br.ufmt.ic.alg3.cinema.entidades.Assento;
import br.ufmt.ic.alg3.cinema.entidades.Sala;
import br.ufmt.ic.alg3.cinema.persistencia.AssentoDAO;
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
public class AssentoDAOImplPostgreSQL implements AssentoDAO {

    private Connection con;
    
    private void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema", "user", "user");
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Assento assento) {
        conectar();
        
        String sql = "INSERT INTO assento (sala, numero) VALUES (?, ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, assento.getSala().getId());
            ps.setInt(1, assento.getNumero());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public void editar(Assento assento) {
        conectar();
        
        String sql = "UPDATE assento SET sala = ?, numero = ? WHERE id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, assento.getSala().getId());
            ps.setInt(2, assento.getNumero());
            ps.setInt(3, assento.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public boolean remover(int id) {
        conectar();

        String sql = "DELETE FROM assento WHERE id = " + id +";";
        
        try {
            con.createStatement().execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        
        return false;
    }

    @Override
    public Assento getById(int id) {
        Assento a = null;
        
        conectar();
        
        String sql = 
                "SELECT \n" +
                "	assento.id,\n" +
                "	assento.sala,\n" +
                "	assento.numero,\n" +
                "	sala.nome\n" +
                "	\n" +
                "FROM assento\n" +
                "INNER JOIN sala \n" +
                "ON sala.id = assento.sala\n" +
                "WHERE assento.id = " + id;
        
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                a = new Assento();
                Sala s = new Sala();
                
                a.setId(rs.getInt("id"));
                a.setNumero(rs.getInt("numero"));
                
                s.setId(rs.getInt("sala"));
                s.setNome(rs.getString("nome"));
                
                a.setSala(s);
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return a;
    }

    @Override
    public List<Assento> listar() {
        conectar();

        List<Assento> lista = new ArrayList<>();
        
        String sql = 
                "SELECT \n" +
                "	assento.id,\n" +
                "	assento.sala,\n" +
                "	assento.numero,\n" +
                "	sala.nome\n" +
                "	\n" +
                "FROM assento\n" +
                "INNER JOIN sala \n" +
                "ON sala.id = assento.sala;";
        
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Assento a = new Assento();
                Sala s = new Sala();
                
                a.setId(rs.getInt("id"));
                a.setNumero(rs.getInt("numero"));
                
                s.setId(rs.getInt("sala"));
                s.setNome(rs.getString("nome"));
                
                a.setSala(s);
                
                lista.add(a);
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return lista;
    }
    
}
