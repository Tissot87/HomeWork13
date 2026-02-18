package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Stream;

public class ProductBasket {

     Map<String, List<Product>> mapOfProducts = new HashMap<>();

    public  void addProduct(Product product){

        List<Product> basket = mapOfProducts.getOrDefault(product.getName(), new ArrayList<>());
        basket.add(product);
        mapOfProducts.put(product.getName(), basket);

   }

    public  int calculationTotalSum(){

        return mapOfProducts.values()
                 .stream()
                 .flatMap(Collection::stream)
                 .filter(Objects::nonNull)
                 .mapToInt(Product::getCost)
                .sum();
    }

    public  void printBasket(){

        mapOfProducts.values()
                .stream()
                .forEach(i -> System.out.println(i.toString()));
    }

    public  boolean checkProduct(String product){

       return mapOfProducts.values()
               .stream()
               .flatMap(Collection::stream)
               .anyMatch(i -> i.getName().equalsIgnoreCase(product));
    }

    public  List<Product> clearing(String name){

        List<Product> listOfDeletedProducts = new LinkedList<>();

        if (mapOfProducts.containsKey(name)){
            listOfDeletedProducts.addAll(mapOfProducts.get(name));
            mapOfProducts.remove(name);
        }

        return listOfDeletedProducts;
    }

    public long countSpecialProducts(){

        return mapOfProducts.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }

    @Override
    public String toString() {
            return "ProductBasket{" +
                    "basket=" + mapOfProducts +
                    '}';
    }
}
