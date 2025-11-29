package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {

    Searchable[] searchingItems;

    public SearchEngine(int size) {
        this.searchingItems = new Searchable[size];
    }

    public Searchable[] search(String searchTerm){
        Searchable[] resultArray = new Searchable[5];
        int countItems = 0;
        for (Searchable s : searchingItems){
            if (s != null && s.searchTerm().contains(searchTerm)){
                resultArray[countItems] = s;
                countItems++;
            }
            if (countItems == 4){
                break;
            }
        }
        return resultArray;
    }

    public void add(Searchable item){
        for (int i = 0; i < searchingItems.length; i++){
            if (searchingItems[i] != null){
                continue;
            }else {
                searchingItems[i] = item;
                if (i == searchingItems.length - 1){
                    System.out.println("Массив полон");
                }
                break;
            }


        }
    }


}
