package org.example;

import java.util.List;

public class App {

    public static void main( String[] args )  {
        //Se crea una instancia de la cartera
        Portfolio portfolio = new Portfolio();

        //Obtener la asignación objetivo y valores reales actuales
        List<Stock> allocatedStocks = portfolio.getAllocatedStocks();
        List<Stock> stocks = portfolio.getStocks();

        //Demostración del rebalanceo de cartera
        portfolio.portfolioRebalance(stocks, allocatedStocks);

    }
}
