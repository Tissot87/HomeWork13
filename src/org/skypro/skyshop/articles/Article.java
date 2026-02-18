package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
