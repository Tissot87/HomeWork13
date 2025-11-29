package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {

    private final String articleName;

    private final String articleText;


    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return articleName + "/n" + articleText;
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }
}
