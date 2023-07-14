package org.example;

public class KrwCalc implements ICalculator{
    private  int pirce = 1;


    @Override
    public int sum(int a, int b) {
        a *= pirce;
        b *= pirce;
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        a *= pirce;
        b *= pirce;
        return a-b;
    }
}
