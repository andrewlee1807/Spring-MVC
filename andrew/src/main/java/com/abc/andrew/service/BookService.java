package com.abc.andrew.service;

import com.abc.andrew.model.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookByIdFully(int id);
    public Book getBookByIdSingle(int id);
    public void removeBook(int id);
    public List<Book> listBooksByPage(int paged, int total);    // for paging
    public int countTotalItem();                                // Sum of books
}
