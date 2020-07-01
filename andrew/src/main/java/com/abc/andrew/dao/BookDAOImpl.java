package com.abc.andrew.dao;

import com.abc.andrew.model.Author;
import com.abc.andrew.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class BookDAOImpl implements BookDAO{
//    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory;   }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(book);
        tx.commit();
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> listBooks() {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Book> listBooks = session.createQuery("from Book").list();
//        List<Book> listBooks = session.createCriteria(Book.class).list();
        tx.commit();
        return listBooks;
    }

    @Override
    public List<Book> listBooksByPage(int page, int maxResults){
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select u from Book u");
        query.setFirstResult(page*maxResults);
        query.setMaxResults(maxResults);
//        List<Book> listBooks = session.createCriteria(Book.class).setFirstResult(offset).setMaxResults(maxResults).list();
        List<Book> rs = query.list();
        tx.commit();
        return rs;
    }

    @Override
    public Book getBookByIdSingle(int id) {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Book book = (Book)session.get(Book.class, id);
        tx.commit();
        return book;
    }

    @Override
    public Book getBookByIdFully(int id) {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Book book = (Book)session.get(Book.class, id);
// Fetch all Authors for a book by id from database - "NOW"
        book.getListAuthor().size();
//        System.out.println("------------------------");
//        System.out.println(book.getListAuthor());
        tx.commit();
        return book;
    }


    @Override
    public void removeBook(int id) {
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Book book = (Book)session.load(Book.class, id);
        if (book != null){
            session.delete(book);
        }
        tx.commit();
    }

    @Override
    public int countTotalItem(){
        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select count(u) from Book u");
        long count = (long) query.list().get(0);
        tx.commit();
        return  (int) count;
    }

}
