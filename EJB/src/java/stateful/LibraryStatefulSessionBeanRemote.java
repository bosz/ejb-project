/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateful;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author martin
 */
@Remote
public interface LibraryStatefulSessionBeanRemote {

    void addBook(String bookName);

    List getBooks();

}
