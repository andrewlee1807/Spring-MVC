package com.abc.andrew.dao;

import com.abc.andrew.model.Author;
import com.abc.andrew.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
//    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory;    }
    public SessionFactory getSessionFactory() {  return sessionFactory;    }

    @Override
    public void addAuthor(Author author) {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(author);
        tx.commit();
    }

    @Override
    public void updateAuthor(Author author) {
        Session session = this.getSessionFactory().getCurrentSession();
        session.update(author);
    }

    @Override
    public void removeAuthor(int id) {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Author author = (Author) session.load(Author.class, id);
        if (author != null){
            session.delete(author);
        }
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Author> listAuthors() {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
//        List<Author> listAuthors = session.createQuery("from author ").list();
        List<Author> listAuthors = session.createCriteria(Author.class).list();
        tx.commit();
        return listAuthors;
    }

    @Override
    public Author getAuthorById(int id) {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Author author = (Author) session.get(Author.class, id);
// Fetch all Books for a author by id from database - "NOW"
        author.getListBook().size();
        tx.commit();
        return author;
    }



}
