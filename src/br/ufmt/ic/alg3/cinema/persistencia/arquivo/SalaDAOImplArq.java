/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.arquivo;

import br.ufmt.ic.alg3.cinema.entidades.Sala;
import br.ufmt.ic.alg3.cinema.persistencia.SalaDAO;
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
public class SalaDAOImplArq implements SalaDAO {

    private final String filename = "salas.dat";
    private List<Sala> salas = new ArrayList<>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename)
            );
            oos.writeObject(salas);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(SalaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarArquivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename)
            );
            salas = (List<Sala>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(SalaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Sala sala) {
        carregarArquivo();
        
        boolean existe = false;
        for (Sala sala1 : salas) {
            if (sala1.getId() == sala.getId()) {
                existe = true;
                break;
            }
        }
        
        if (!existe) {
            salas.add(sala);
            salvarArquivo();
            System.out.println("Sala cadastrada com sucesso!");
        } else {
            System.out.println("Sala já cadastrada!");
        }
            
    }

    @Override
    public void editar(Sala sala) {
        carregarArquivo();
        
        for (Sala sala1 : salas) {
            if (sala1.getId() == sala.getId()) {
                salas.set(sala1.getId(), sala);
                salvarArquivo();
                break;
            }
        }

    }

    @Override
    public boolean remover(int id) {
        carregarArquivo();
        
        for (Sala sala : salas) {
            if (sala.getId() == id) {
                salas.remove(sala);
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Sala getById(int id) {
        carregarArquivo();
        
        for (Sala sala : salas) {
            if (sala.getId() == id) {
                return sala;
            }
        }
        
        return null;
    }

    @Override
    public List<Sala> listar() {
        carregarArquivo();
        return salas;
    }
    
}
