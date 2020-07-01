package com.abc.andrew.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author", schema = "public")
public class Author {
// Attribute
    @Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAuthor;
    private String name;

    @ManyToMany(mappedBy = "listAuthor")
    private Set<Book> listBook = new HashSet<>();

// Getter and Setter
    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getListBook() {
        return listBook;
    }

    public void setListBook(Set<Book> listBook) {
        this.listBook = listBook;
    }

    // Constructor
    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    @Override
    public String toString(){
        return "ID : " + this.getIdAuthor()+"\nName : " + this.getName() +  "\n";
    }
}
