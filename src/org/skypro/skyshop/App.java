package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product product1 = new SimpleProduct("Sugar", 10);

        Product product2 = new DiscountedProduct("Salt", 100, 2);

        Product product3 = new FixPriceProduct("Potato");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        Article article1 = new Article("Potato", "Text1");

        Article article2 = new Article("Text", "Milk");
        Article article3 = new Article("Text", "Text3");
        Article article4 = new Article("Text", "Text4");
        Article article5 = new Article("Text", "Text5");



        SearchEngine a = new SearchEngine(5);
        a.add(product1);
        a.add(product2);
        a.add(product3);
        a.add(article1);
        a.add(article2);
        a.add(article3);
        a.add(article4);
        a.add(article5);

        System.out.println(Arrays.toString(a.search("Potato")));
        System.out.println(Arrays.toString(a.search("Milk")));
        System.out.println(Arrays.toString(a.search("Text1")));

  //      basket.printBasket();





    }
}
