package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    List<Searchable> searchingItems = new ArrayList<>();


    public Map<String, Searchable> search(String searchTerm){
        Map<String, Searchable> resultList = new TreeMap<>();
        for (Searchable s : searchingItems) {
            System.out.println("    ");
            if (s != null && s.searchTerm().contains(searchTerm)) {
                resultList.put(s.searchTerm(), s);

            }
        }
//        int countItems = 0;
//        Iterator<Searchable> searchItemsIterator = searchingItems.iterator();
//        while (searchItemsIterator.hasNext()){
//            Searchable searchingItem = searchItemsIterator.next();
//            if (searchingItem != null && searchingItem.searchTerm().contains(searchTerm)){
//                resultList.put(searchingItem, searchingItem);
//                countItems++;
//            }
//            if (countItems == 4){
//                break;
//            }
//        }
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
