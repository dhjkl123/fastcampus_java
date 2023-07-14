package org.example;

public class DollarCalc implements ICalculator{
    private int price = 1;
    private MarketApi marketApi;
    public DollarCalc(MarketApi marketApi){
        this.marketApi = marketApi;
    }

    public void init(){
        this.price = marketApi.connect();
    }


    @Override
    public int sum(int a, int b) {
        a *= this.price;
        b *= this.price;
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        a *= this.price;
        b *= this.price;
        return a-b;
    }
}
