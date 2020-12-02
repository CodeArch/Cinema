/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.postgresql;

import br.ufmt.ic.alg3.cinema.entidades.Filme;
import br.ufmt.ic.alg3.cinema.entidades.Sala;
import br.ufmt.ic.alg3.cinema.entidades.Sessao;
import br.ufmt.ic.alg3.cinema.persistencia.SessaoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrique
 */
public class SessaoDAOImplPostgreSQL implements SessaoDAO {

    private Connection con;

    private void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema", "user", "user");
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Sessao sessao) {
        conectar();

        String sql = "INSERT INTO sessao (filme, sala, data_hora) VALUES (?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, sessao.getFilme().getId());
            ps.setInt(2, sessao.getSala().getId());
            ps.setObject(3, sessao.getDataHora());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }

    @Override
    public void editar(Sessao sessao) {
        conectar();

        String sql = "UPDATE sessao SET filme = ?, sala = ?, data_hora = ? WHERE id = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, sessao.getFilme().getId());
            ps.setInt(2, sessao.getSala().getId());
            ps.setObject(3, sessao.getDataHora());

            ps.setInt(4, sessao.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }

    @Override
    public boolean remover(int id) {
        conectar();

        String sql = "DELETE FROM sessao WHERE id = " + id + ";";

        try {
            con.createStatement().execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return false;
    }

    @Override
    public Sessao getById(int id) {
        conectar();

        Sessao s = null;

        String sql
                = "SELECT\n"
                + "	sessao.id,\n"
                + "	sessao.filme,\n"
                + "	filme.nome AS nome_filme,\n"
                + "	filme.duracao,\n"
                + "	filme.filme3d,\n"
                + "	sessao.sala,\n"
                + "	sala.nome AS nome_sala,\n"
                + "	sessao.data_hora\n"
                + "FROM\n"
                + "	sessao\n"
                + "INNER JOIN filme\n"
                + "ON filme.id = sessao.filme\n"
                + "INNER JOIN sala\n"
                + "ON sala.id = sessao.sala\n"
                + "WHERE sessao.id = " + id + ";";

        try {
            ResultSet rs = con.createStatement().executeQuery(sql);

            if (rs.next()) {
                s = new Sessao();

                Filme filme = new Filme();
                Sala sala = new Sala();

                s.setId(rs.getInt("id"));

                filme.setId(rs.getInt("filme"));
                filme.setNome(rs.getString("nome_filme"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setFilme3d(rs.getBoolean("filme3d"));

                sala.setId(rs.getInt("sala"));
                sala.setNome(rs.getString("nome_sala"));

                s.setFilme(filme);
                s.setSala(sala);

                s.setDataHora((Timestamp) rs.getObject("data_hora"));
            }

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();

        return s;
    }

    @Override
    public List<Sessao> listar() {
        conectar();

        List<Sessao> lista = new ArrayList<>();

        String sql
                = "SELECT\n"
                + "	sessao.id,\n"
                + "	sessao.filme,\n"
                + "	filme.nome AS nome_filme,\n"
                + "	filme.duracao,\n"
                + "	filme.filme3d,\n"
                + "	sessao.sala,\n"
                + "	sala.nome AS nome_sala,\n"
                + "	sessao.data_hora\n"
                + "FROM\n"
                + "	sessao\n"
                + "INNER JOIN filme\n"
                + "ON filme.id = sessao.filme\n"
                + "INNER JOIN sala\n"
                + "ON sala.id = sessao.sala;";

        try {
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                Sessao s = new Sessao();

                Filme filme = new Filme();
                Sala sala = new Sala();

                s.setId(rs.getInt("id"));

                filme.setId(rs.getInt("filme"));
                filme.setNome(rs.getString("nome_filme"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setFilme3d(rs.getBoolean("filme3d"));

                sala.setId(rs.getInt("sala"));
                sala.setNome(rs.getString("nome_sala"));

                s.setFilme(filme);
                s.setSala(sala);

                s.setDataHora((Timestamp) rs.getObject("data_hora"));
                
                lista.add(s);
            }

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDAOImplPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();

        return lista;

    }

}
