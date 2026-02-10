package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

     Map<String, List<Product>> mapOfProducts = new HashMap<>();

    public  void addProduct(Product product){

        List<Product> basket = mapOfProducts.getOrDefault(product.getName(), new ArrayList<>());
        basket.add(product);
        mapOfProducts.put(product.getName(), basket);

   }

    public  int calculationTotalSum(){

        int totalSum = 0;

        for (List<Product> listOfProduct : mapOfProducts.values()){
           for (Product product1 : listOfProduct)
            if (product1 != null) {
                totalSum = totalSum + product1.getCost();
            }
        }
        return totalSum;
    }

    public  void printBasket(){

        if (mapOfProducts != null) {
            for (List<Product> listOfProduct : mapOfProducts.values()) {
                for (Product product : listOfProduct )
                    if (product != null) {
                        System.out.println(product);
                    }else continue;
            }
        }else System.out.println("В корзине пусто");

        System.out.println("Итого: " + calculationTotalSum());
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    public  boolean checkProduct(String product){
        for (List<Product> inBasketProduct : mapOfProducts.values()){
            for (Product product1 : inBasketProduct)
               if(inBasketProduct != null){
                    if (product1.getName().equals(product)) {
                    return true;
                    }
               }
        }
        return false;
    }

    public  List<Product> clearing(String name){

        List<Product> listOfDeletedProducts = new LinkedList<>();

        if (mapOfProducts.containsKey(name)){
            listOfDeletedProducts.addAll(mapOfProducts.get(name));
            mapOfProducts.remove(name);
        }

        return listOfDeletedProducts;
    }

    public int countSpecialProducts(){
        int countSpecialProducts = 0;
        for (List<Product> basket : mapOfProducts.values()) {
            for (Product product : basket) {
                if (product != null) {
                    if (product.isSpecial()) {
                        countSpecialProducts++;
                    }
                }
            }
        }
        return countSpecialProducts;
    }

    @Override
    public String toString() {
            return "ProductBasket{" +
                    "basket=" + mapOfProducts +
                    '}';
    }
}
