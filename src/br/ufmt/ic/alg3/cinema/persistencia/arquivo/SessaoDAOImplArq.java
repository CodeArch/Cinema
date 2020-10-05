/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.arquivo;

import br.ufmt.ic.alg3.cinema.entidades.Sessao;
import br.ufmt.ic.alg3.cinema.persistencia.SessaoDAO;
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
public class SessaoDAOImplArq implements SessaoDAO {

    private final String filename = "sessoes.dat";
    private List<Sessao> sessoes = new ArrayList<Sessao>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename)
            );
            oos.writeObject(sessoes);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(SessaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarArquivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename)
            );
            sessoes = (List<Sessao>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(SessaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Sessao sessao) {
        carregarArquivo();
        
        boolean existe = false;
        for (Sessao s : sessoes) {
            if (sessao.getId() == s.getId()) {
                existe = true;
                break;
            }
        }
        
        if (!existe) {
            sessoes.add(sessao);
            salvarArquivo();
            System.out.println("Sessão cadastrada com sucesso!");
        } else {
            System.out.println("Sessão já cadastrada!");
        }
    }

    @Override
    public void editar(Sessao sessao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sessao getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessao> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
