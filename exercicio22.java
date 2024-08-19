// Classe que representa o papel Client
class Client {
    public static void main(String[] args) {
        // Criação do Director e dos Builders de cada tipo
        Director director = new Director();
        Builder contatoInternetBuilder = new ContatoInternetBuilder();
        Builder contatoTelefoneBuilder = new ContatoTelefoneBuilder();
        Builder contatoCompletoBuilder = new ContatoCompletoBuilder();

        // Criação de contatos de cada tipo
        director.construirContato(contatoInternetBuilder, "John Doe", "john.doe@example.com");
        Contato contatoInternet = contatoInternetBuilder.obterContato();

        director.construirContato(contatoTelefoneBuilder, "Jane Smith", "1234567890");
        Contato contatoTelefone = contatoTelefoneBuilder.obterContato();

        director.construirContato(contatoCompletoBuilder, "Bob Johnson", "123 Main St", "9876543210", "bob.johnson@example.com");
        Contato contatoCompleto = contatoCompletoBuilder.obterContato();

        // Impressão dos contatos
        System.out.println(contatoInternet.toString());
        System.out.println(contatoTelefone.toString());
        System.out.println(contatoCompleto.toString());
    }
}

// Classe que representa o papel Director
class Director {
    public void construirContato(Builder builder, String nome, String... args) {
        builder.criarContato(nome, args);
        builder.construir();
    }
}

// Interface que representa o papel Builder
interface Builder {
    void criarContato(String nome, String... args);
    void construir();
    Contato obterContato();
}

// Classe que representa o contato de Internet
class ContatoInternetBuilder implements Builder {
    private String nome;
    private String email;

    @Override
    public void criarContato(String nome, String... args) {
        this.nome = nome;
        this.email = args[0];
    }

    @Override
    public void construir() {
        // Nenhuma construção adicional necessária para o contato de Internet
    }

    @Override
    public Contato obterContato() {
        return new ContatoInternet(nome, email);
    }
}

// Classe que representa o contato de Telefone
class ContatoTelefoneBuilder implements Builder {
    private String nome;
    private String telefone;

    @Override
    public void criarContato(String nome, String... args) {
        this.nome = nome;
        this.telefone = args[0];
    }

    @Override
    public void construir() {
        // Nenhuma construção adicional necessária para o contato de Telefone
    }

    @Override
    public Contato obterContato() {
        return new ContatoTelefone(nome, telefone);
    }
}

// Classe que representa o contato Completo
class ContatoCompletoBuilder implements Builder {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    @Override
    public void criarContato(String nome, String... args) {
        this.nome = nome;
        this.endereco = args[0];
        this.telefone = args[1];
        this.email = args[2];
    }

    @Override
    public void construir() {
        // Nenhuma construção adicional necessária para o contato Completo
    }

    @Override
    public Contato obterContato() {
        return new ContatoCompleto(nome, endereco, telefone, email);
    }
}

// Classe que representa o contato de Internet
class ContatoInternet {
    private String nome;
    private String email;

    public ContatoInternet(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato de Internet:\n" +
               "Nome: " + nome + "\n" +
               "Email: " + email + "\n";
    }
}

// Classe que representa o contato de Telefone
class ContatoTelefone {
    private String nome;
    private String telefone;

    public ContatoTelefone(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato de Telefone:\n" +
               "Nome: " + nome + "\n" +
               "Telefone: " + telefone + "\n";
    }
}

// Classe que representa o contato Completo
class ContatoCompleto {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public ContatoCompleto(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato Completo:\n" +
               "Nome: " + nome + "\n" +
               "Endereço: " + endereco + "\n" +
               "Telefone: " + telefone + "\n" +
               "Email: " + email + "\n";
    }
}
