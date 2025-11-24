package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product product1 = new SimpleProduct("Sugar", 10);

        Product product2 = new DiscountedProduct("Salt", 100, 2);

        Product product3 = new FixPriceProduct("Potato");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);




        basket.printBasket();





    }
}
