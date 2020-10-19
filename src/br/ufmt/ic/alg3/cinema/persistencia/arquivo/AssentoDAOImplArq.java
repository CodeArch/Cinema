/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.arquivo;

import br.ufmt.ic.alg3.cinema.entidades.Assento;
import br.ufmt.ic.alg3.cinema.entidades.Sala;
import br.ufmt.ic.alg3.cinema.persistencia.AssentoDAO;
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
public class AssentoDAOImplArq implements AssentoDAO {

    private final String filename = "assentos.dat";
    private List<Assento> assentos = new ArrayList<>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename)
            );
            oos.writeObject(assentos);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(AssentoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarArquivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename)
            );
            assentos = (List<Assento>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(AssentoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AssentoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void inserir(Assento assento) {
        carregarArquivo();
        
        boolean existe = false;
        for (Assento assento1 : assentos) {
            if (assento1.getId() == assento.getId() &&
                    assento1.getSala().getId() == assento.getSala().getId())
            {
                existe = true;
                break;
            }

        }
        if (!existe) {
            assentos.add(assento);
            salvarArquivo();
            System.out.println("Assento cadastrado com sucesso!");
        } else {
            System.out.println("Assento já cadastrado!");
        }

    }

    @Override
    public void editar(Assento assento) {
        carregarArquivo();
        
        for (Assento assento1 : assentos) {
            if (assento1.getId() == assento.getId() && 
                    assento1.getSala().getId() == assento.getSala().getId()) {
                int index = assentos.indexOf(assento1);
                assentos.set(index, assento);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean remover(int id, Sala sala) {
        carregarArquivo();
        
        for (Assento assento : assentos) {
            if (assento.getId() == id && assento.getSala().getId() == sala.getId()) {
                assentos.remove(assento);
                salvarArquivo();
                
                return true;
            }
        }
        
        return false;

    }

    @Override
    public Assento getById(int id) {
        carregarArquivo();
        
        for (Assento assento : assentos) {
            if (assento.getId() == id) {
                return assento;
            }
        }
        
        return null;

    }

    @Override
    public List<Assento> listar() {
        carregarArquivo();
        return assentos;
    }
    
}
