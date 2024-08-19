import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Interface do provedor de informações
interface ProvedorInformacao {
    String obterInformacao();
}

// Provedor de informações públicas
class ProvedorInformacaoPublica implements ProvedorInformacao {
    private String arquivo;

    public ProvedorInformacaoPublica(String arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public String obterInformacao() {
        return lerArquivo(arquivo);
    }

    private String lerArquivo(String arquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    }
}

// Provedor de informações confidenciais
class ProvedorInformacaoConfidencial implements ProvedorInformacao {
    private String arquivo;
    private String senha;

    public ProvedorInformacaoConfidencial(String arquivo, String senha) {
        this.arquivo = arquivo;
        this.senha = senha;
    }

    @Override
    public String obterInformacao() {
        if (senha.equals("designpatterns")) {
            return lerArquivo(arquivo);
        } else {
            return "Acesso negado. Senha incorreta.";
        }
    }

    private String lerArquivo(String arquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    }
}

// Classe cliente que utiliza as provedoras de informações
public class Main {
    public static void main(String[] args) {
        String arquivoPublico = "publico.txt";
        String arquivoConfidencial = "confidencial.txt";
        String senha = args.length > 0 ? args[0] : "";

        ProvedorInformacao provedorInformacao = null;

        if (senha.equals("designpatterns")) {
            provedorInformacao = new ProvedorInformacaoConfidencial(arquivoConfidencial, senha);
        } else {
            provedorInformacao = new ProvedorInformacaoPublica(arquivoPublico);
        }

        String informacao = provedorInformacao.obterInformacao();
        System.out.println(informacao);
    }
}
