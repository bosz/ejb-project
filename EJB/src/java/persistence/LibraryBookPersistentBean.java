/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ulrich
 */
@Stateless
public class LibraryBookPersistentBean implements LibraryBookPersistentBeanRemote {

    public LibraryBookPersistentBean() {
    }
    @PersistenceContext(unitName = "EjbModulePU")
    private EntityManager entityManager;

    public void addBook(Book book) {
        entityManager.persist(book);
    }

    public List<Book> getBooks() {
        //return entityManager.createQuery("From Book").getResultList();
        //return entityManager.createNamedQuery("Book.findAll").getResultList();
        Query q2 = entityManager.createQuery("SELECT b FROM Books b");
        
        return q2.getResultList();
    }
}
