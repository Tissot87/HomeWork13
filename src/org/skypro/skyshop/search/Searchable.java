package org.skypro.skyshop.search;

public interface Searchable extends Comparable {

    String searchTerm();

    String contentType();

    default String getStringRepresentation(){
        return this.searchTerm() + " - " + this.contentType();
    }


}
