package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{

    int baseCost;

    int discount;

    public DiscountedProduct(String name, int baseCost, int discount) throws IllegalArgumentException {
        super(name);
        if ((this.baseCost = baseCost) < 1){
            throw new IllegalArgumentException();
        }
        this.discount = discount;
        if (discount < 0 || discount > 100){
            throw new IllegalArgumentException();
        }
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
