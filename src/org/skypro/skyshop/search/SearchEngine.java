package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

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

    public Searchable findBest (String search) throws BestResultNotFound {

        Searchable bestMatch = null;
        int maxMatches = 0;

        for (Searchable s: searchingItems){
            if (s == null){
                continue;
            }
            String str = s.searchTerm();
            String substring = search;
            int count = 0;
            int index = 0;
            int indexSubstring = str.indexOf(substring, index);

            while(indexSubstring != -1){
                count++;
                index = indexSubstring + substring.length();
                indexSubstring = str.indexOf(substring, index);
            }

            if (count > maxMatches){
                maxMatches = count;
                bestMatch = s;
            }
        }

        if (bestMatch == null){
            throw new BestResultNotFound();
        }

        return bestMatch;
    }


}
