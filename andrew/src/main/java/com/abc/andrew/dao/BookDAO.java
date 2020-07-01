package com.abc.andrew.dao;

import com.abc.andrew.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO {
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookByIdSingle(int id);
    public Book getBookByIdFully(int id);
    public void removeBook(int id); // should be change the flag_active = -1
    public List<Book> listBooksByPage(int paged, int total);
    public int countTotalItem();
}
