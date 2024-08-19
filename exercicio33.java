import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Interface do logger
interface Logger {
    void log(String message);
}

// Implementação do logger para log em arquivo
class FileLogger implements Logger {
    private String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Implementação do logger para log no console
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

// Fábrica de loggers
class LoggerFactory {
    public Logger createLogger(String type) {
        if (type.equalsIgnoreCase("arquivo")) {
            return new FileLogger("log.txt");
        } else if (type.equalsIgnoreCase("console")) {
            return new ConsoleLogger();
        } else {
            throw new IllegalArgumentException("Tipo de logger inválido.");
        }
    }
}

// Classe cliente que utiliza a ferramenta de log
public class Main {
    public static void main(String[] args) {
        String logType = args.length > 0 ? args[0] : "";

        LoggerFactory loggerFactory = new LoggerFactory();
        Logger logger = loggerFactory.createLogger(logType);

        for (int i = 1; i <= 10; i++) {
            logger.log(String.valueOf(i));
        }
    }
}
