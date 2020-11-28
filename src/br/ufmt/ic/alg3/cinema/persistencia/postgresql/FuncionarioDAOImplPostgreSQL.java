/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.postgresql;

import br.ufmt.ic.alg3.cinema.entidades.Funcionario;
import br.ufmt.ic.alg3.cinema.persistencia.FuncionarioDAO;
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
public class FuncionarioDAOImplPostgreSQL implements FuncionarioDAO {

    private Connection con;

    private void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema", "user", "user");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Funcionario funcionario) {
        conectar();

        String sql = "INSERT INTO funcionario (nome, cpf, endereco, telefone) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getEndereco());
            ps.setString(4, funcionario.getTelefone());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }

    @Override
    public void editar(Funcionario funcionario) {
        conectar();

        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, endereco = ?, telefone = ? WHERE id = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getEndereco());
            ps.setString(4, funcionario.getTelefone());
            ps.setInt(5, funcionario.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }

    @Override
    public boolean remover(int id) {
        conectar();

        String sql = "DELETE FROM funcionario WHERE id = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return false;
    }

    @Override
    public Funcionario getById(int id) {
        conectar();

        String sql = "SELECT * FROM funcionario WHERE id = ?;";
        Funcionario f = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();

        return f;
    }

    @Override
    public List<Funcionario> listar() {
        conectar();

        String sql = "SELECT * FROM funcionario";
        List<Funcionario> lista = new ArrayList<>();
        
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
                lista.add(f);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
        return lista;
    }

}
