/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.postgresql;

import br.ufmt.ic.alg3.cinema.entidades.Filme;
import br.ufmt.ic.alg3.cinema.persistencia.FilmeDAO;
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
public class FilmeDAOImplPostgreSQL implements FilmeDAO {

    private Connection con;
    
    private void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema", "user", "user");
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Filme filme) {
        conectar();
        
        String sql = "INSERT INTO filme (nome, duracao, filme3d) VALUES (?, ?, ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, filme.getNome());
            ps.setInt(2, filme.getDuracao());
            ps.setBoolean(3, filme.isFilme3d());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public void editar(Filme filme) {
        conectar();
        
        String sql = "UPDATE filme SET nome = ?, duracao = ?, filme3d = ? WHERE id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, filme.getNome());
            ps.setInt(2, filme.getDuracao());
            ps.setBoolean(3, filme.isFilme3d());
            ps.setInt(4, filme.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public boolean remover(int id) {
        conectar();

        String sql = "DELETE FROM filme WHERE id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return false;
    }

    @Override
    public Filme getById(int id) {
        conectar();
        
        Filme f = null;
        
        String sql = "SELECT * FROM filme WHERE id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                f = new Filme();
                
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setDuracao(rs.getInt("duracao"));
                f.setFilme3d(rs.getBoolean("filme3d"));
            }            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return f;
    }

    @Override
    public List<Filme> listar() {
        conectar();

        List<Filme> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM filme;";
        
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Filme f = new Filme();
                
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setDuracao(rs.getInt("duracao"));
                f.setFilme3d(rs.getBoolean("filme3d"));
                
                lista.add(f);
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();

        return lista;
    }
    
}
