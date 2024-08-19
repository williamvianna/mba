class Incremental {
    private static Incremental instance;
    private static int count = 0;
    private int numero;

    private Incremental() {
        numero = ++count;
    }

    public static Incremental getInstance() {
        if (instance == null) {
            instance = new Incremental();
        }
        return instance;
    }

    public String toString() {
        return "Incremental " + numero;
    }
}

public class TesteIncremental {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Incremental inc = Incremental.getInstance();
            System.out.println(inc);
        }
    }
}
