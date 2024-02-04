package org.example.factory.pizzaaf;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();

        nyStore.orderPizza("cheese");
    }
}
