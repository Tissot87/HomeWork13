package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {


        Product product1 = new Product("Sugar", 10);
        Product product2 = new Product("Salt", 1);
        Product product3 = new Product("Rice", 100);
        Product product4 = new Product("Chocolate", 150);
        Product product5 = new Product("Potato", 20);
        Product product6 = new Product("Onion", 9);

        ProductBasket.addProduct(product1);
        ProductBasket.addProduct(product2);
        ProductBasket.addProduct(product3);


        ProductBasket.calculationTotalSum();

        ProductBasket.printBasket();

        ProductBasket.checkProduct("Salt");

        ProductBasket.clear();



    }
}
