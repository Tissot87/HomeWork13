package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

   private Set<Searchable> searchingItems = new HashSet<>();




    public Set<Searchable> search(String searchTerm) {

        return   searchingItems.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.searchTerm().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toCollection(()-> new TreeSet<>(new ReverseComparator())));

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

    public static class ReverseComparator implements Comparator<Searchable> {

        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthComparison = Integer.compare(
                    o2.searchTerm().length(),
                    o1.searchTerm().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return o1.searchTerm().compareTo(o2.searchTerm());
        }

    }

}
