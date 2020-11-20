/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.postgresql;

import br.ufmt.ic.alg3.cinema.entidades.Caixa;
import br.ufmt.ic.alg3.cinema.entidades.Funcionario;
import br.ufmt.ic.alg3.cinema.persistencia.CaixaDAO;
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
public class CaixaDAOImplPostgreSQL implements CaixaDAO{

    private Connection con;
    
    private void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema", "user", "user");
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Caixa caixa) {
        conectar();
        
        String sql = "INSERT INTO caixa (funcionario) VALUES (?);";
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, caixa.getFuncionario().getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public void editar(Caixa caixa) {
        conectar();
        
        String sql = "UPDATE caixa SET funcionario = ? WHERE id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, caixa.getFuncionario().getId());
            ps.setInt(2, caixa.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
    }

    @Override
    public boolean remover(int id) {
        conectar();
        
        String sql = "DELETE FROM caixa WHERE id = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        
        return false;
    }

    @Override
    public Caixa getById(int id) {
        conectar();

        String sql = 
                "SELECT \n" +
                "	caixa.id, \n" +
                "	funcionario.id AS funcionario, \n" +
                "	funcionario.nome,\n" +
                "	funcionario.cpf,\n" +
                "	funcionario.endereco,\n" +
                "	funcionario.telefone\n" +
                "FROM caixa\n" +
                "LEFT JOIN funcionario ON caixa.funcionario=funcionario.id\n" +
                "WHERE caixa.id = ?;";
       
        Caixa c = null;
        Funcionario f = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new Caixa();
                c.setId(rs.getInt("id"));
                if (rs.getInt("funcionario") != 0) {
                    f = new Funcionario();
                    f.setId(rs.getInt("funcionario"));
                    f.setNome(rs.getString("nome"));
                    f.setCpf(rs.getString("cpf"));
                    f.setEndereco(rs.getString("endereco"));
                    f.setTelefone(rs.getString("telefone"));
                }
                c.setFuncionario(f);
                
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return c;
    }

    @Override
    public List<Caixa> listar() {
        conectar();
        
        String sql = 
                "SELECT \n" +
                "	caixa.id, \n" +
                "	funcionario.id AS funcionario, \n" +
                "	funcionario.nome,\n" +
                "	funcionario.cpf,\n" +
                "	funcionario.endereco,\n" +
                "	funcionario.telefone\n" +
                "FROM caixa\n" +
                "LEFT JOIN funcionario ON caixa.funcionario=funcionario.id;";
        
        List<Caixa> lista = new ArrayList<>();
        
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Caixa c = new Caixa();
                c.setId(rs.getInt("id"));
                
                if (rs.getInt("funcionario") != 0) {
                    Funcionario f = new Funcionario();
                    f.setId(rs.getInt("funcionario"));
                    f.setNome(rs.getString("nome"));
                    f.setCpf(rs.getString("cpf"));
                    f.setEndereco(rs.getString("endereco"));
                    f.setTelefone(rs.getString("telefone"));
                    
                    c.setFuncionario(f);
                }
                
                lista.add(c);
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectar();
        
        return lista;
    }
    
}
