package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Calculator calculator = new Calculator(new KrwCalc());

        System.out.println(calculator.sum(10,10));

        MarketApi marketApi = new MarketApi();
        DollarCalc dollarCalc = new DollarCalc(marketApi);

        Calculator calculator1 = new Calculator(dollarCalc);

        System.out.println(calculator.sum(10,10));

    }
}