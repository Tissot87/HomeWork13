package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

   int cost;

    public SimpleProduct(String name, int cost) throws IllegalArgumentException {
        super(name);
        if ((this.cost = cost) < 1){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ":" + getCost();
    }


}
