/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.arquivo;

import br.ufmt.ic.alg3.cinema.entidades.Caixa;
import br.ufmt.ic.alg3.cinema.persistencia.CaixaDAO;
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
public class CaixaDAOImplArq implements CaixaDAO {

    private final String filename = "caixas.dat";
    private List<Caixa> caixas = new ArrayList<>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename)
            );
            oos.writeObject(caixas);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(CaixaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarArquivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename)
            );
            caixas = (List<Caixa>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(CaixaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaixaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Caixa caixa) {
        carregarArquivo();
        
        boolean existe = false;
        for (Caixa caixa1 : caixas) {
            if (caixa1.getId() == caixa.getId()) {
                existe = true;
                break;
            }
        }
        
        if (!existe) {
            caixas.add(caixa);
            salvarArquivo();
            System.out.println("Caixa cadastrado com sucesso!");
        } else {
            System.out.println("Caixa já cadastrado!");
        }
        
    }

    @Override
    public void editar(Caixa caixa) {
        carregarArquivo();
        
        for (Caixa caixa1 : caixas) {
            if (caixa1.getId() == caixa.getId()) {
                caixas.set(caixa1.getId(), caixa);
                salvarArquivo();
                break;
            }
        }

    }

    @Override
    public boolean remover(int id) {
        carregarArquivo();
        
        for (Caixa caixa : caixas) {
            if (caixa.getId() == id) {
                caixas.remove(caixa);
                salvarArquivo();
                
                return true;
            }
        }
        
        return false;

    }

    @Override
    public Caixa getById(int id) {
        carregarArquivo();
        
        for (Caixa caixa : caixas) {
            if (caixa.getId() == id) {
                return caixa;
            }
        }
        
        return null;

    }

    @Override
    public List<Caixa> listar() {
        carregarArquivo();
        return caixas;
    }
    
}
