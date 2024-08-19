import random


# Abstract Product: Interface para a impressão
class Printer:
    def print_message(self, message):
        pass


# Concrete Product: Implementação da impressão na tela
class ScreenPrinter(Printer):
    def print_message(self, message):
        print(message)


# Concrete Product: Implementação da impressão em arquivo
class FilePrinter(Printer):
    def print_message(self, message):
        with open("output.txt", "a") as file:
            file.write(message + "\n")


# Abstract Factory: Interface para as fábricas
class PrinterFactory:
    def create_printer(self):
        pass


# Concrete Factory 1: Fábrica para criar a impressão na tela
class ScreenPrinterFactory(PrinterFactory):
    def create_printer(self):
        return ScreenPrinter()


# Concrete Factory 2: Fábrica para criar a impressão em arquivo
class FilePrinterFactory(PrinterFactory):
    def create_printer(self):
        return FilePrinter()


# Função para escolher aleatoriamente entre as fábricas
def get_random_printer_factory():
    factories = [ScreenPrinterFactory(), FilePrinterFactory()]
    return random.choice(factories)


# Programa principal
def main():
    message = "Hello, World!"

    factory = get_random_printer_factory()
    printer = factory.create_printer()

    printer.print_message(message)


if __name__ == "__main__":
    main()
