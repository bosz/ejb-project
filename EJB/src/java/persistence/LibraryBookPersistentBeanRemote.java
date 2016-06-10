/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Book;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author martin
 */
@Remote
public interface LibraryBookPersistentBeanRemote {

    void addBook(Book bookName);

    List<Book> getBooks();

}
