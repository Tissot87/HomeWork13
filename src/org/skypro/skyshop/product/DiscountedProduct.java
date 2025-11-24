package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{

    int baseCost;

    int discount;

    public DiscountedProduct(String name, int baseCost, int discount) {
        super(name);
        this.baseCost = baseCost;
        this.discount = discount;
    }

    @Override
    public int getCost() {
        if (0 < discount && discount <100) {
            return baseCost - (baseCost/100*discount);
        }else {return -1;}
    }

    @Override
    public String toString() {
        return getName() + ":" + getCost() + " (скидка) " + discount + "%";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
