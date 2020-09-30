package cinema;

import br.ufmt.ic.alg3.cinema.entidades.Assento;
import br.ufmt.ic.alg3.cinema.entidades.Caixa;
import br.ufmt.ic.alg3.cinema.entidades.Filme;
import br.ufmt.ic.alg3.cinema.entidades.Funcionario;
import br.ufmt.ic.alg3.cinema.entidades.Ingresso;
import br.ufmt.ic.alg3.cinema.entidades.Sala;
import br.ufmt.ic.alg3.cinema.entidades.Sessao;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.sql.Time;
import java.time.LocalTime;

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
        
        Funcionario f1 = new Funcionario();
        f1.setId(0);
        f1.setCpf("123.456.789-00");
        f1.setNome("Teste da Silva");
        f1.setEndereco("Avenida dos Testes, 123-W");
        f1.setTelefone("(65) 1234-5678");
        
        Caixa c1 = new Caixa();
        c1.setId(0);
        c1.setFuncionario(f1);
        
        Filme filme1 = new Filme();
        filme1.setId(0);
        filme1.setNome("Só Mais Um Filme");
        filme1.setDuracao(240);
        filme1.setFilme3d(true);
        
        Assento assentos[] = new Assento[5];
        assentos[0] = new Assento();
        assentos[0].setId(0);
        
        Sala sala1 = new Sala();
        sala1.setId(0);
        sala1.setAssentos(assentos);
        assentos[0].setSala(sala1);
        
        Sessao s1 = new Sessao();
        s1.setId(0);
        s1.setFilme(filme1);
        s1.setData(Date.from(Instant.now()));
        System.out.println(s1.getData());
        s1.setHorario(Time.valueOf(LocalTime.now()));
        System.out.println(s1.getHorario());
        s1.setSala(sala1);
        
        Sessao s2 = new Sessao();
        s2.setId(1);
        
        Ingresso i1 = new Ingresso();
        i1.setId(0);
        i1.setValor(BigDecimal.ZERO);
        i1.setTipo('I');
        i1.setAssentoReservado(assentos[0]);
        
    }
    
}
