package com.abc.andrew.service;

import com.abc.andrew.dao.BookDAO;
import com.abc.andrew.dto.BookDTO;
import com.abc.andrew.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        List<BookDTO> listBook;
        return this.bookDAO.listBooks();
    }

    @Override
    @Transactional
    public List<Book> listBooksByPage(int offset, int maxResult) {
        List<BookDTO> listBook;
        return this.bookDAO.listBooksByPage(offset, maxResult);
    }

    @Override
    @Transactional
    public Book getBookByIdSingle(int id) {
        return this.bookDAO.getBookByIdSingle(id);
    }

    @Override
    @Transactional
    public Book getBookByIdFully(int id) {
        return this.bookDAO.getBookByIdFully(id);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.bookDAO.removeBook(id);
    }

    @Override
    @Transactional
    public int countTotalItem(){
        return this.bookDAO.countTotalItem();
    }
}
