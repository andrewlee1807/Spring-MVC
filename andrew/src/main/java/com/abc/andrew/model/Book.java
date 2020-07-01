package com.abc.andrew.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book", schema = "public")
public class Book {
// Attribute
    @Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBook;
    @Column(name = "name")
    private String nameBook;
    private String isbn;
    @Column(name = "issue_date")
    private String issueDate;
    @Column(name = "category_name")
    private String categoryDate;
    private float price;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> listAuthor = new HashSet<>();

// Getter and Setter Book Object
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

    public Set<Author> getListAuthor() {
        return listAuthor;
    }

    public void setListAuthor(Set<Author> listAuthor) {
        this.listAuthor = listAuthor;
    }

    // Constructor
    public Book(String nameBook) {
        this.nameBook = nameBook;
    }

    public Book() {
    }

    @Override
    public String toString(){
        return "Book : " + this.getIdBook() + "\nName :"+this.getNameBook() + "\nisbn : " + this.getIsbn() +
                "\n" + this.getCategoryDate() + "\n" + this.getIssueDate() + "\n" + this.getPrice() + "\n";
    }
}
