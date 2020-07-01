package com.abc.andrew.service;

import com.abc.andrew.model.Author;

import java.util.List;

public interface AuthorService {
    public void addAuthor(Author author);
    public void updateAuthor(Author author);
    public List<Author> listAuthors();
    public Author getAuthorById(int id);
    public void removeAuthor(int id); // should be change the flag_active = -1
}

