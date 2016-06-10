/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stateless;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author martin
 */
@Stateless
public class LibraryStatelessBean implements LibraryStatelessBeanRemote {

    List<String> bookShelf;
    
    public LibraryStatelessBean() {
        
        bookShelf = new ArrayList<String>();
        
    }

    public LibraryStatelessBean(List<String> bookShelf) {
        this.bookShelf = bookShelf;
    }

    
    
    public void addBook(String bookName) {
        bookShelf.add(bookName);
    }

    public List getBooks() {
        return bookShelf;
    }
}
