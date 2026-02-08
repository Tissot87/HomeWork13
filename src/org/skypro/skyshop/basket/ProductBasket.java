package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Searchable;

import java.util.*;

public class ProductBasket {



     HashMap<String, List<Product>> mapOfProducts = new HashMap<>();

     int totalSum = 0;



    public  void addProduct(Product product){

        List<Product> basket = mapOfProducts.getOrDefault(product.getName(), new ArrayList<>());
        basket.add(product);
        mapOfProducts.put(product.getName(), basket);

   }


    public  int calculationTotalSum(){

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

        calculationTotalSum();
        System.out.println("Итого: " + totalSum);
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    public  boolean checkProduct(String product){
        for (List<Product> inBasketProduct : mapOfProducts.values()){
            for (Product product1 : inBasketProduct)
               if(inBasketProduct != null){
                    if (product1.getName().equals(product)) {
                    }return true;
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
//
//            Iterator<Product> clearBasketIterator = products.iterator();
//
//            while (clearBasketIterator.hasNext()) {
//                Product clearingProduct = clearBasketIterator.next();
//                if (clearingProduct.getName().equals(name)) {
//                    clearBasketIterator.remove();
//                    listOfDeletedProducts.add(clearingProduct);
//                }
//            }
//        }

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
