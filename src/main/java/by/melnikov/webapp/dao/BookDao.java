package by.melnikov.webapp.dao;

import by.melnikov.webapp.entity.Author;
import by.melnikov.webapp.entity.Book;
import by.melnikov.webapp.entity.Store;

import java.util.List;

public interface BookDao {
        void addBook(Book book);
        void updateBookPrice(int id, int price);
        void removeBookById(int id);
        void removeBookByTitle(String title);
        Book findBookById(int id);
        Book findBookByTitle(String title);
        List<Book> findAllBooks();
        List<Book> findAllBooksByAuthor(Author author);
        List<Book> findAllBooksByStore(Store store);
}
