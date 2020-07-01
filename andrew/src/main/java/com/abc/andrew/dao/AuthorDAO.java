package com.abc.andrew.dao;

import com.abc.andrew.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AuthorDAO {
    public void addAuthor(Author author);
    public void updateAuthor(Author author);
    public List<Author> listAuthors();
    public Author getAuthorById(int id);
    public void removeAuthor(int id); // should be change the flag_active = -1
}
