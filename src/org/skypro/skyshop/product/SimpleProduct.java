package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product{

   int cost;

    @Override
    public String getName() {
        return super.getName();
    }

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


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
