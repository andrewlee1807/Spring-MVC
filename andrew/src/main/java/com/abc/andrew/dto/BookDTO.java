package com.abc.andrew.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDTO {

    private Integer idBook;
    private String nameBook;
    private String isbn;
    private String issueDate;
    private String categoryDate;
    private float price;
    private List<AuthorDTO> listAuthor;



    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getCategoryDate() {
        return categoryDate;
    }

    public void setCategoryDate(String categoryDate) {
        this.categoryDate = categoryDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<AuthorDTO> getListAuthor() {
        return listAuthor;
    }

    public void setListAuthor(List<AuthorDTO> listAuthor) {
        this.listAuthor = listAuthor;
    }

    public BookDTO(Integer idBook, String nameBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
    }

    public BookDTO() {
        this.idBook = 0;
        this.setNameBook("");
    }

     @Override
    public String toString(){
        return "Book : " + this.getIdBook() + "\nName :"+this.getNameBook() + "\nisbn : " + this.getIsbn() +
                "\n" + this.getCategoryDate() + "\n" + this.getIssueDate() + "\n" + this.getPrice() + "\n";
    }
}
