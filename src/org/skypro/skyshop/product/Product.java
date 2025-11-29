package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    private final String name;


    public Product(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract int getCost();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String contentType() {
        return "PRODUCT";
    }
}
