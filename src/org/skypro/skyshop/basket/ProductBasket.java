package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    static Product[] basket = new Product[5];

    static int totalSum = 0;



    public static void addProduct(Product product){
        for (int i = 0; i < basket.length; i++) {

            if (basket[i] == null) {
                basket[i] = product;
                System.out.println(product.getName());
                break;

            } else if (i == basket.length-1){System.out.println("Невозможно добавить продукт");

            }
        }


    }


    public static int calculationTotalSum(){

        for (Product product : basket){
            if (product != null) {
                totalSum = totalSum + product.getCost();
            }
        }
        return totalSum;
    }

    public static void printBasket(){

        if (basket != null) {
            for (Product product : basket) {
                if (product != null) {
                    System.out.println(product.getName() + " : " + product.getCost());
                }else continue;
            }
        }else System.out.println("В корзине пусто");

        System.out.println("Итого: " + totalSum);
    }

    public static boolean checkProduct(String product){
        for (Product inBasketProduct : basket){
            if (inBasketProduct.getName().equals(product)){
                return true;
            }
        }
        return false;
    }

    public static void clear(){
        for (int i = 0; i < basket.length; i++){
             basket[i] = null;
        }
    }
}
