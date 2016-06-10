/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Remote;
import entities.Books;
import java.util.List;

/**
 *
 * @author ulrich
 */
@Remote
public interface LibraryPersistentBeanRemote {

    void addBook(Books bookName);

    List<Books> getBooks();
}
