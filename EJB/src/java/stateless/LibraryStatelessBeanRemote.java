/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author martin
 */
@Remote
public interface LibraryStatelessBeanRemote {

    void addBook(String bookName);

    List getBooks();
}
