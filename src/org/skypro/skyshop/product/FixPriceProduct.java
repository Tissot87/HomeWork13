package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{

    private static final int FIX_COST = 50;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getCost() {
        return FIX_COST;
    }

    @Override
    public String toString() {
        return getName() + ":" + " Фиксированная цена " + getCost();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
