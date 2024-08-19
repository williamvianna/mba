import java.util.HashSet;
import java.util.Set;

// Classe que representa o pedido finalizado
class Pedido {
    private Set<String> dentroDaCaixa = new HashSet<String>();
    private Set<String> foraDaCaixa = new HashSet<String>();

    public void adicionarDentroDaCaixa(String item) {
        dentroDaCaixa.add(item);
    }

    public void adicionarForaDaCaixa(String item) {
        foraDaCaixa.add(item);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Seu pedido:\n");
        buffer.append("Dentro da caixa:\n");
        for (String item : dentroDaCaixa) {
            buffer.append("\t" + item + "\n");
        }
        buffer.append("Fora da caixa:\n");
        for (String item : foraDaCaixa) {
            buffer.append("\t" + item + "\n");
        }
        buffer.append("\nTenha um bom dia!\n\n");
        return buffer.toString();
    }
}

// Classe que constrói o pedido
class PedidoBuilder {
    private Pedido pedido = new Pedido();

    public void adicionarDentroDaCaixa(String item) {
        pedido.adicionarDentroDaCaixa(item);
    }

    public void adicionarForaDaCaixa(String item) {
        pedido.adicionarForaDaCaixa(item);
    }

    public Pedido obterPedido() {
        return pedido;
    }
}

// Classe que representa o atendente
class Atendente {
    private PedidoBuilder pedidoBuilder;

    public Atendente(PedidoBuilder pedidoBuilder) {
        this.pedidoBuilder = pedidoBuilder;
    }

    public void adicionarHamburguer() {
        pedidoBuilder.adicionarDentroDaCaixa("Hambúrguer");
    }

    public void adicionarCheeseburger() {
        pedidoBuilder.adicionarDentroDaCaixa("Cheeseburger");
    }

    public void adicionarBatataPequena() {
        pedidoBuilder.adicionarDentroDaCaixa("Batata Pequena");
    }

    public void adicionarBatataMedia() {
        pedidoBuilder.adicionarDentroDaCaixa("Batata Média");
    }

    public void adicionarBatataGrande() {
        pedidoBuilder.adicionarDentroDaCaixa("Batata Grande");
    }

    public void adicionarBrinquedoCarrinho() {
        pedidoBuilder.adicionarDentroDaCaixa("Carrinho");
    }

    public void adicionarBrinquedoBonequinha() {
        pedidoBuilder.adicionarDentroDaCaixa("Bonequinha");
    }

    public void adicionarRefrigeranteCoca() {
        pedidoBuilder.adicionarForaDaCaixa("Refrigerante Coca");
    }

    public void adicionarRefrigeranteGuarana() {
        pedidoBuilder.adicionarForaDaCaixa("Refrigerante Guaraná");
    }
}

// Classe que representa o funcionário de montagem
class FuncionarioMontagem {
    public Pedido montarPedido(PedidoBuilder pedidoBuilder) {
        // Aqui o funcionário realiza a montagem do pedido de acordo com as regras da empresa
        return pedidoBuilder.obterPedido();
    }
}

// Classe cliente que faz o pedido e recebe o lanche pronto
public class Cliente {
    public static void main(String[] args) {
        PedidoBuilder pedidoBuilder = new PedidoBuilder();
        Atendente atendente = new Atendente(pedidoBuilder);
        FuncionarioMontagem funcionarioMontagem = new FuncionarioMontagem();

        atendente.adicionarHamburguer();
        atendente.adicionarBatataMedia();
        atendente.adicionarBrinquedoCarrinho();
        atendente.adicionarRefrigeranteCoca();

        Pedido pedido = funcionarioMontagem.montarPedido(pedidoBuilder);

        System.out.println(pedido.toString());
    }
}
