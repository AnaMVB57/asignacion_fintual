package org.example;

// Clase que representa una acción (Stock) de una empresa
// incluyendo su nombre y precio (En porcentaje)

public class Stock {

    //Atributos de la clase
    private String name;
    private double price;

    //Constructor de la clase Stock
    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Representación del Stock como String
    @Override
    public String toString() {
        return "Stock{" +
                "'" + name + '\'' +
                ", " + price + '%' + '\'' +
                '}';
    }

    // Simulación de precio actual de la acción (entre 0 y 100)
    public static double currentPrice(){
        return Math.round(Math.random() * 100);
    }
}