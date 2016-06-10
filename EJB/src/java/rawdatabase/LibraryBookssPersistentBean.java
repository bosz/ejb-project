/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rawdatabase;

import entities.Bookss;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ulrich
 */
@Stateless
public class LibraryBookssPersistentBean implements LibraryBookssPersistentBeanRemote {

    public LibraryBookssPersistentBean() {
    }

    public void addBook(Bookss book) {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String driver = "org.postgresql.driver";
        String userName = "root";
        String password = "root";
        List<Bookss> books = new ArrayList<Bookss>();
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st
                    = con.prepareStatement("insert into bookss(name) values(?)");
            st.setString(1, book.getName());
            int result = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public List<Bookss> getBooks() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String driver = "org.postgresql.driver";
        String userName = "root";
        String password = "root";
        List<Bookss> books = new ArrayList<Bookss>();
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from bookss");
            Bookss book;
            while (rs.next()) {
                book = new Bookss();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return books;
    }
}
