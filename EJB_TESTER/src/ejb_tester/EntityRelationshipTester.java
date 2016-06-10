/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb_tester;

import entities.Author;
import entities.Book;
import persistence.LibraryBookPersistentBeanRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author martin
 */
public class EntityRelationshipTester {

    BufferedReader brConsoleReader = null;
    Properties props;
    InitialContext ctx;

    {
        props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put(Context.PROVIDER_URL, "localhost");
//        try {
//            props.load(new FileInputStream("jndi.properties"));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        try {
            ctx = new InitialContext(props);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        brConsoleReader
                = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        EntityRelationshipTester ejbTester = new EntityRelationshipTester();
        ejbTester.testEmbeddedObjects();
    }

    private void showGUI() {
        System.out.println("**********************");
        System.out.println("Welcome to Book Store");
        System.out.println("**********************");
        System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
    }

    private void testEmbeddedObjects() {
        try {
            int choice = 1;
            LibraryBookPersistentBeanRemote libraryBean
                    = (LibraryBookPersistentBeanRemote) ctx.lookup("LibraryBookPersistentBean/remote");
            while (choice != 2) {
                String bookName;
                String authorName;
                showGUI();
                String strChoice = brConsoleReader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print("Enter book name: ");
                    bookName = brConsoleReader.readLine();
                    System.out.print("Enter author name: ");
                    authorName = brConsoleReader.readLine();
                    Book book = new Book();
                    book.setName(bookName);
                    Author author = new Author();
                    author.setName(authorName);
                    Set<Author> authors = new HashSet<>();
                    authors.add(author);
                    book.setAuthors(authors);
                    libraryBean.addBook(book);
                } else if (choice == 2) {

                    break;
                }
            }
            List<Book> booksList = libraryBean.getBooks();
            System.out.println("Book(s) entered so far: " + booksList.size());
            int i = 0;
            for (Book book : booksList) {
                System.out.println((i + 1) + ". " + book.getName());
                System.out.print("Author: ");
                Author[] authors;
                authors = (Author[]) book.getAuthors();//.toArray();
                for (int j = 0; j < authors.length; j++) {
                    System.out.println(authors[j]);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (brConsoleReader != null) {
                    brConsoleReader.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
