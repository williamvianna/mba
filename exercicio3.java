import java.util.ArrayList;
import java.util.List;

// Classe principal que recebe os nomes como parâmetro
public class Nomes {
    public static void main(String[] args) {
        // Criação das aplicações de construção de nomes
        AplicacaoConcreta1 aplicacao1 = new AplicacaoConcreta1();
        AplicacaoConcreta2 aplicacao2 = new AplicacaoConcreta2();

        // Construção dos objetos de nome para cada formato
        for (String arg : args) {
            Nome nome = null;

            // Verifica o formato do nome e utiliza a aplicação apropriada
            if (arg.contains(",")) {
                nome = aplicacao2.criarNome(arg);
            } else {
                nome = aplicacao1.criarNome(arg);
            }

            // Armazena o nome criado
            nome.armazenarNome();
        }

        // Imprime os nomes armazenados
        aplicacao1.imprimirNomes();
        aplicacao2.imprimirNomes();
    }
}

// Classe abstrata que representa a aplicação de construção de nomes
abstract class Aplicacao {
    protected List<Nome> nomes = new ArrayList<>();

    // Método factory method que cria o objeto de nome
    protected abstract Nome criarNome(String arg);

    // Método para armazenar o nome criado
    public void armazenarNome() {
        Nome nome = criarNome();
        nomes.add(nome);
    }

    // Método para imprimir os nomes armazenados
    public void imprimirNomes() {
        for (Nome nome : nomes) {
            System.out.println(nome.getNomeCompleto());
        }
    }
}

// Aplicação concreta para o formato "nome sobrenome"
class AplicacaoConcreta1 extends Aplicacao {
    @Override
    protected Nome criarNome(String arg) {
        String[] partes = arg.split(" ");
        String nome = partes[0];
        String sobrenome = partes[1];
        return new Nome(nome, sobrenome);
    }
}

// Aplicação concreta para o formato "sobrenome, nome"
class AplicacaoConcreta2 extends Aplicacao {
    @Override
    protected Nome criarNome(String arg) {
        String[] partes = arg.split(",");
        String nome = partes[1].trim();
        String sobrenome = partes[0].trim();
        return new Nome(nome, sobrenome);
    }
}

// Classe que representa um nome
class Nome {
    private String nome;
    private String sobrenome;

    public Nome(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }
}
