package com.bookworm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookworm.dao.BookDao;
import com.bookworm.model.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
        session.flush();
    }
    
    public void editBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
        session.flush();
    }

    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.get(Book.class, id);
        session.flush();

        return book;
    }

    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book");
        List<Book> products = query.list();
        session.flush();

        return products;
    }

    public void deleteBook (int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getBookById(id));
        session.flush();
    }
}