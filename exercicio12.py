import datetime


# Abstract Product 1: Pizza
class Pizza:
    def get_ingredients(self):
        pass


# Concrete Product 1.1: CalabresaPizza
class CalabresaPizza(Pizza):
    def get_ingredients(self):
        return "Queijo + Calabresa + Tomate"


# Concrete Product 1.2: PresuntoPizza
class PresuntoPizza(Pizza):
    def get_ingredients(self):
        return "Queijo + Presunto + Tomate"


# Abstract Product 2: Calzone
class Calzone:
    def get_ingredients(self):
        pass


# Concrete Product 2.1: CalabresaCalzone
class CalabresaCalzone(Calzone):
    def get_ingredients(self):
        return "Queijo + Calabresa (calzone)"


# Concrete Product 2.2: PresuntoCalzone
class PresuntoCalzone(Calzone):
    def get_ingredients(self):
        return "Queijo + Presunto (calzone)"


# Abstract Factory: PizzaFactory
class PizzaFactory:
    def create_pizza(self):
        pass

    def create_calzone(self):
        pass


# Concrete Factory 1: CalabresaPizzaFactory
class CalabresaPizzaFactory(PizzaFactory):
    def create_pizza(self):
        return CalabresaPizza()

    def create_calzone(self):
        return CalabresaCalzone()


# Concrete Factory 2: PresuntoPizzaFactory
class PresuntoPizzaFactory(PizzaFactory):
    def create_pizza(self):
        return PresuntoPizza()

    def create_calzone(self):
        return PresuntoCalzone()


# Cliente: Pizzaria
class Pizzaria:
    def __init__(self, factory):
        self.factory = factory

    def get_menu(self, date):
        day = date.weekday()
        if day in [0, 2, 4]:  # Segundas, quartas e sextas
            return self.factory.create_pizza()
        elif day in [1, 3, 5]:  # Terças, quintas e sábados
            return self.factory.create_calzone()
        else:  # Domingos
            return None


# Programa principal
def main():
    date_input = input("Digite a data (dd/mm/yyyy): ")
    date = datetime.datetime.strptime(date_input, "%d/%m/%Y").date()

    factory = None
    if date.weekday() in [0, 2, 4]:  # Segundas, quartas e sextas
        factory = CalabresaPizzaFactory()
    elif date.weekday() in [1, 3, 5]:  # Terças, quintas e sábados
        factory = PresuntoPizzaFactory()

    pizzaria = Pizzaria(factory)
    menu_item = pizzaria.get_menu(date)

    if menu_item:
        print("Ingredientes:", menu_item.get_ingredients())
    else:
        print("A pizzaria está fechada.")


if __name__ == "__main__":
    main()
