/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.arquivo;

import br.ufmt.ic.alg3.cinema.entidades.Filme;
import br.ufmt.ic.alg3.cinema.persistencia.FilmeDAO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henrique
 */
public class FilmeDAOImplArq implements FilmeDAO {

    private final String filename = "filmes.dat";
    private List<Filme> filmes = new ArrayList<>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename)
            );
            oos.writeObject(filmes);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(FilmeDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarArquivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename)
            );
            filmes = (List<Filme>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(FilmeDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Filme filme) {
        carregarArquivo();
        boolean existe = false;
        
        for (Filme f : filmes) {
            if (f.getId() == filme.getId()) {
                existe = true;
                break;
            }
        }
        
        if (!existe) {
            filmes.add(filme);
            salvarArquivo();
            System.out.println("Curso cadastrado com sucesso!");
        } else {
            System.out.println("Filme já cadastrado!");
        }
    }

    @Override
    public void editar(Filme filme) {
        carregarArquivo();
        
        for (Filme filme1 : filmes) {
            if (filme1.getId() == filme.getId()) {
                filmes.set(filme1.getId(), filme);
                salvarArquivo();
                break;
            }
        }

    }

    @Override
    public boolean remover(int id) {
        carregarArquivo();
        
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                filmes.remove(filme);
                salvarArquivo();
                
                return true;
            }
        }

        return false;
    }

    @Override
    public Filme getById(int id) {
        carregarArquivo();
        
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                return filme;
            }
        }
        
        return null;
    }

    @Override
    public List<Filme> listar() {
        carregarArquivo();
        return filmes;
    }
    
}
