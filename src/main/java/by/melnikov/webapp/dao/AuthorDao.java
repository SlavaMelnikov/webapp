package by.melnikov.webapp.dao;

import by.melnikov.webapp.entity.Author;
import by.melnikov.webapp.entity.Book;

import java.util.List;

public interface AuthorDao {
    int addAuthor(Author author);
    void removeAuthor(Author author);
    void removeAuthorById(int id);
    Author findAuthorById(int id);
    int findAuthorId(Author author);
    Author findAuthorByBook(Book book);
    List<Author> findAllAuthors();
}
