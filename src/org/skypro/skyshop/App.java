package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();


        Product product1 = null;
        try {
            product1 = new SimpleProduct("Salt", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        Product product2 = null;
        try {
            product2 = new DiscountedProduct("Honey", 100, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught");
        }


        Product product3 = null;
        try {
            product3 = new FixPriceProduct("Potato");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        Article article1 = new Article("Potato", "Text1");

        Article article2 = new Article("Text", "Milk");
        Article article3 = new Article("Text", "Text3");
        Article article4 = new Article("Text", "Text4");
        Article article5 = new Article("Text", "Text5");

        System.out.println(basket);

        SearchEngine a = new SearchEngine();
        a.add(product1);
        a.add(product2);
        a.add(product3);
        a.add(article1);
        a.add(article2);
        a.add(article3);
        a.add(article4);
        a.add(article5);


        try {
            System.out.println(a.findBest("Honey"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }


        basket.clearing("Potato");

        System.out.println(a.search("Potato"));


    }
}
