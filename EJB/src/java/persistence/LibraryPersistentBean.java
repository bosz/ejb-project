/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Books;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.persistence.TypedQuery;

/**
 *
 * @author martin
 */
@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

    public LibraryPersistentBean() {
    }

    @PersistenceContext(unitName = "EjbModulePU")
    private EntityManager entityManager;

    public void addBook(Books book) {
        entityManager.persist(book);
    }

    public List<Books> getBooks() {
        //return entityManager.createQuery("From Book").getResultList();
        Query q2 = entityManager.createQuery("SELECT b FROM Books b");

        return q2.getResultList();
        //return entityManager.createNamedQuery("Books.findAll").getResultList();
        
//        //create an ejbql expression
//        String ejbQL = "SELECT b FROM Book b where b.name like ?1";
////        String ejbQL = "From Book b where b.name like ?1";
//        //create query
//        Query query = entityManager.createQuery(ejbQL);
//        //substitute parameter.
//        query.setParameter(1, "%test%");
//        //execute the query
//        return query.getResultList();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct:: LibraryPersistentBean session bean"
                + " created with entity Manager object: ");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy: LibraryPersistentBean session"
                + " bean is removed ");
    }
}
