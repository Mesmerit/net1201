package ru.netology.domain;


public class Book extends Product{
    private String author;

    public Book(int id, String title, int price, String author) {
        super(id, title ,price);
        this.author = author;
    }

    @Override
    public boolean matches (String query){
        if (title.contains(query)) {
            return  true;
        }
        if (author.contains(query)){
            return true;
        }
        return false;
    }
}
