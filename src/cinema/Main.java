package cinema;

import br.ufmt.ic.alg3.cinema.entidades.Filme;
import br.ufmt.ic.alg3.cinema.entidades.Sala;
import br.ufmt.ic.alg3.cinema.entidades.Sessao;
import br.ufmt.ic.alg3.cinema.persistencia.FilmeDAO;
import br.ufmt.ic.alg3.cinema.persistencia.SessaoDAO;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.FilmeDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.SessaoDAOImplArq;
import java.util.Date;

/**
 *
 * @author henrique
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Filme f = new Filme();
        f.setId(0);
        f.setNome("Teste 2: O Retorno dos Bugs");
        f.setDuracao(240);
        f.setFilme3d(true);
        
        FilmeDAO banco = new FilmeDAOImplArq();
        banco.inserir(f);

        System.out.println(banco.listar().toString());
        
        Sessao s = new Sessao();
        s.setId(0);
        s.setFilme(f);
        s.setSala(new Sala());
        s.setDataHora(new Date(0));
        
        SessaoDAO banco2 = new SessaoDAOImplArq();
        banco2.inserir(s);
        System.out.println(banco2.getById(0).toString());
        
    }
    
}
