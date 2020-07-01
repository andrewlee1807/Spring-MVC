package com.abc.andrew.service;

import com.abc.andrew.dao.AuthorDAO;
import com.abc.andrew.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO;
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        this.authorDAO.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        this.authorDAO.updateAuthor(author);
    }

    @Override
    @Transactional
    public List<Author> listAuthors() {
        return this.authorDAO.listAuthors();
    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return this.authorDAO.getAuthorById(id);
    }

    @Override
    @Transactional
    public void removeAuthor(int id) {
        this.authorDAO.removeAuthor(id);
    }
}
