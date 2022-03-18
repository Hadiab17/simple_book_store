package com.hadiabbasi.practice.Model;

public class BookModel {

    private String bookName;
    private String authorName;
    private String imageUrl;

    public BookModel() {
    }

    public BookModel(String bookName, String authorName, String imageUrl){
        this.bookName = bookName;
        this.authorName = authorName;
        this.imageUrl = imageUrl;
    }

    public BookModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
