package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
//создали список для поиска
    List<Searchable> searchingItems = new ArrayList<>();

//нужно сделать списки и итераторы для каждого класса и реализовать действия классов !!!каждого!!!
    public List<Searchable> search(String searchTerm){
        List<Searchable> resultList = new LinkedList<>();
        int countItems = 0;
        Iterator<Searchable> searchItemsIterator = searchingItems.iterator();
        while (searchItemsIterator.hasNext()){
            Searchable searchingItem = searchItemsIterator.next();
            if (searchingItem != null && searchingItem.searchTerm().contains(searchTerm)){
                resultList.add(searchingItem);
                countItems++;
            }
            if (countItems == 4){
                break;
            }
        }
        return resultList;
    }

    public void add(Searchable item){
       searchingItems.add(item);
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
