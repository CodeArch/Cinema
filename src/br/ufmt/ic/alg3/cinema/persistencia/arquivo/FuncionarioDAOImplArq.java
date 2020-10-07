/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.persistencia.arquivo;

import br.ufmt.ic.alg3.cinema.entidades.Funcionario;
import br.ufmt.ic.alg3.cinema.persistencia.FuncionarioDAO;
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
public class FuncionarioDAOImplArq implements FuncionarioDAO {

    private final String filename = "funcionarios.dat";
    private List<Funcionario> funcionarios = new ArrayList<>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename)
            );
            oos.writeObject(funcionarios);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarArquivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename)
            );
            funcionarios = (List<Funcionario>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Funcionario funcionario) {
        carregarArquivo();
        
        boolean existe = false;
        for (Funcionario funcionario1 : funcionarios) {
            if (funcionario1.getId() == funcionario.getId()) {
                existe = true;
                break;
            }
        }
        
        if (!existe) {
            funcionarios.add(funcionario);
            salvarArquivo();
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Funcionário já cadastrado!");
        }

    }

    @Override
    public void editar(Funcionario funcionario) {
        carregarArquivo();
        
        for (Funcionario funcionario1 : funcionarios) {
            if (funcionario1.getId() == funcionario.getId()) {
                funcionarios.set(funcionario1.getId(), funcionario);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean remover(int id) {
        carregarArquivo();
        
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionarios.remove(funcionario);
                salvarArquivo();
                
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Funcionario getById(int id) {
        carregarArquivo();
        
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        
        return null;
    }

    @Override
    public List<Funcionario> listar() {
        carregarArquivo();
        return funcionarios;
    }
    
}
