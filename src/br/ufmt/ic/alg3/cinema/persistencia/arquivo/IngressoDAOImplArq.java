/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.arquivo;

import br.ufmt.ic.alg3.cinema.entidades.Ingresso;
import br.ufmt.ic.alg3.cinema.persistencia.IngressoDAO;
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
public class IngressoDAOImplArq implements IngressoDAO{

    private final String filename = "ingressos.dat";
    private List<Ingresso> ingressos = new ArrayList<>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename)
            );
            oos.writeObject(ingressos);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(IngressoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarArquivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename)
            );
            ingressos = (List<Ingresso>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(IngressoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngressoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Ingresso ingresso) {
        carregarArquivo();
        
        boolean existe = false;
        for (Ingresso ingresso1 : ingressos) {
            if (ingresso1.getId() == ingresso.getId()) {
                existe = true;
                break;
            }
        }
        
        if (!existe) {
            ingressos.add(ingresso);
            salvarArquivo();
            System.out.println("Ingresso cadastrado com sucesso!");
        } else {
            System.out.println("Ingresso já cadastrado!");
        }

    }

    @Override
    public void editar(Ingresso ingresso) {
        carregarArquivo();
        
        for (Ingresso ingresso1 : ingressos) {
            if (ingresso1.getId() == ingresso.getId()) {
                int index = ingressos.indexOf(ingresso1);
                ingressos.set(index, ingresso);
                salvarArquivo();
                break;
            }
        }

    }

    @Override
    public boolean remover(int id) {
        carregarArquivo();
        
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId() == id) {
                ingressos.remove(ingresso);
                salvarArquivo();
                
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Ingresso getById(int id) {
        carregarArquivo();
        
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId() == id) {
                return ingresso;
            }
        }
        
        return null;
    }

    @Override
    public List<Ingresso> listar() {
        carregarArquivo();
        return ingressos;
    }

}
