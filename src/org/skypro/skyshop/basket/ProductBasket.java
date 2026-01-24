package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

     List<Product> basket = new ArrayList<>();

     int totalSum = 0;



    public  void addProduct(Product product){

        basket.add(product);
//        for (int i = 0; i < basket.length; i++) {
//
//            if (basket.get(i) == null) {
//                basket[i] = product;
//                break;
//
//            } else if (i == basket.length-1){System.out.println("Невозможно добавить продукт");
//
//            }
//        }
   }


    public  int calculationTotalSum(){

        for (Product product : basket){
            if (product != null) {
                totalSum = totalSum + product.getCost();
            }
        }
        return totalSum;
    }

    public  void printBasket(){

        if (basket != null) {
            for (Product product : basket) {
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
        for (Product inBasketProduct : basket){
            if(inBasketProduct != null){
                if (inBasketProduct.getName().equals(product)) {

                }return true;
            }
        }
        return false;
    }

    public  List<Product> clearing(String name){

        List<Product> listOfDeletedProducts = new LinkedList<>();

        Iterator<Product> clearBasketIterator = basket.iterator();

        while (clearBasketIterator.hasNext()){
             Product clearingProduct = clearBasketIterator.next();
             if (clearingProduct.getName().equals(name)){
                 clearBasketIterator.remove();
                 listOfDeletedProducts.add(clearingProduct);
             }
        }

        return listOfDeletedProducts;
    }



    public int countSpecialProducts(){
        int countSpecialProducts = 0;
        for (Product product : basket){
            if (product != null) {
                if (product.isSpecial()) {
                    countSpecialProducts++;
                }
            }
        }
        return countSpecialProducts;
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "basket=" + basket +
                '}';
    }
}
