/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.postgresql;

import br.ufmt.ic.alg3.cinema.entidades.Sala;
import br.ufmt.ic.alg3.cinema.persistencia.SalaDAO;
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
public class SalaDAOImplPostgreSQL implements SalaDAO{

    private Connection con;
    
    private void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema", "user", "user");
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Sala sala) {
        conectar();
        
        String sql = "INSERT INTO sala (nome) VALUES ('" + sala.getNome() + "');";
        
        try {
            con.createStatement().execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public void editar(Sala sala) {
        conectar();
        
        String sql = "UPDATE sala SET nome = ? WHERE id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, sala.getNome());
            ps.setInt(2, sala.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public boolean remover(int id) {
        conectar();

        String sql = "DELETE FROM sala WHERE id = " + id +";";
        
        try {
            con.createStatement().execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        
        return false;
    }

    @Override
    public Sala getById(int id) {
        conectar();
        
        String sql = "SELECT * FROM sala WHERE id = "+ id + ";";
        
        Sala s = null;
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                s = new Sala();
                
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return s;
    }

    @Override
    public List<Sala> listar() {
        conectar();
        
        List<Sala> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM sala;";
        
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Sala s = new Sala();
                
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                
                lista.add(s);
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return lista;
    }
    
}
