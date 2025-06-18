package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Clase que representa una cartera de inversiones (Portfolio)

public class Portfolio {

    // Se calcula el valor total de la cartera sumando los precios de las acciones
    public double totalPortfolioValue(List<Stock> allocatedStocks){
        double total = 0;
        for (Stock stock : allocatedStocks){
            total += stock.getPrice();
        }
        return total;
    }

    // Simulación de obtención de valores reales del mercado para dos acciones
    public List<Stock> getStocks(){
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("APPL", Stock.currentPrice()));
        stocks.add(new Stock("META", Stock.currentPrice()));
        return stocks;
    }

    // Se asigna el porcentaje ideal de las acciones en la cartera
    public List<Stock> getAllocatedStocks() {
        List<Stock> allocatedStocks = new ArrayList<>();
        allocatedStocks.add(new Stock("APPL", (0.7)*100));
        allocatedStocks.add(new Stock("META", (0.3)*100));
        return allocatedStocks;
    }

    // Compara los valores reales actuales con la asignación de la cartera
    // y recomienda la compra o venta de acciones con el fin de rebalancear la cartera.

    public void portfolioRebalance(List<Stock> realStocks, List<Stock> allocatedStocks){
        double totalValue = totalPortfolioValue(realStocks);

        //Mostrar los porcentajes de la asignación objetivo de la cartera
        System.out.println("Asignación objetivo:");
        for (Stock stock : allocatedStocks){
            System.out.println("- " + stock.getName() + ": " + stock.getPrice() + "% ");
        }

        //Mostrar los porcentajes y los valores monetarios reales de las acciones
        System.out.println("Valores reales actuales:");
        for (Stock stock : realStocks){
            //Calculamos el porcentaje de la acción real
            double percent = (stock.getPrice() / totalValue) * 100;
            System.out.println("- " + stock.getName() + ": " + stock.getPrice() + " (" + Math.round(percent) + "%)");
        }

        //Mapa que guarda la asignación objetivo por nombre
        Map<String, Double> stocksToCompare = new HashMap<>();

        //Insertamos el contenido de allocatedStocks en stocksToCompare
        for (Stock stock : allocatedStocks){
            stocksToCompare.put(stock.getName(), stock.getPrice());
        }

        //Comparamos la lista realStocks son los valores de la asignación de cartera
        for (Stock s : realStocks){

            // Obtener el nombre de la acción
            String name = s.getName();

            // Obtener el valor actual de esa acción
            double realValue = s.getPrice();

            // Calcular el porcentaje que representa esta acción dentro del total del portafolio
            double expectedPercentage = (realValue / totalValue) * 100;

            // Obtener el porcentaje de asignación objetivo desde el mapa
            double realPercent = stocksToCompare.getOrDefault(name, 0.0);

            // Calcular la diferencia entre el porcentaje real actual y el objetivo
            double difference = expectedPercentage - realPercent;

            //Recomendaciones de rebalanceo

            //Si el porcentaje actual supera al objetivo en más de 1%, se recomienda vender
            if(difference > 1){
                System.out.println("Debe vender " + Math.round(difference) + " en acciones de " + name);

            //Si la diferencia es menor a 1%, se recomienda comprar
            }else if(difference < -1){
                System.out.println("Debe comprar " + Math.round(-difference) + " en acciones de " + name);

            //Si no se cumple ninguno de los casos anteriores, no hay recomendación.
            }else{
                System.out.println("No es necesario realizar ajustes. Cartera equilibrada");
            }
        }
    }
}