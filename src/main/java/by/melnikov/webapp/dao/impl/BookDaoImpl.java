package by.melnikov.webapp.dao.impl;

import by.melnikov.webapp.connection.DataSource;
import by.melnikov.webapp.dao.BookDao;
import by.melnikov.webapp.entity.Author;
import by.melnikov.webapp.entity.Book;
import by.melnikov.webapp.entity.Store;
import by.melnikov.webapp.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.melnikov.webapp.util.ColumnNames.*;
import static by.melnikov.webapp.util.query.BookSqlQuery.*;

public class BookDaoImpl implements BookDao {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void addBook(Book book) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_BOOK)) {
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthor().getAuthorId());
            statement.setInt(3, book.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to add new book. %s", e));
            throw new DaoException("Error while attempting to add new book: " + e.getMessage());
        }
    }

    @Override
    public void updateBookPrice(int id, int price) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_PRICE)) {
            statement.setInt(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to update book price. %s", e));
            throw new DaoException("Error while attempting to update book price: " + e.getMessage());
        }
    }

    @Override
    public void removeBookById(int id) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_BOOK_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to remove book by id. %s", e));
            throw new DaoException("Error while attempting to remove book by id: " + e.getMessage());
        }
    }

    @Override
    public void removeBookByTitle(String title) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_BOOK_BY_TITLE)) {
            statement.setString(1, title);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to remove book by title. %s", e));
            throw new DaoException("Error while attempting to remove book by title: " + e.getMessage());
        }
    }

    @Override
    public Book findBookById(int id) {
        Book book = new Book();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_ID)) {
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                book.setTitle(result.getString(TITLE));
//                book.setAuthorId(result.getInt(AUTHOR));
                book.setPrice(result.getInt(PRICE));
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find book by id. %s", e));
            throw new DaoException("Error while attempting to find book by id: " + e.getMessage());
        }
        return book;
    }

    @Override
    public Book findBookByTitle(String title) {
        Book book = new Book();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_TITLE)) {
            statement.setString(1, title);
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                book.setTitle(result.getString(TITLE));
//                book.setAuthorId(result.getInt(AUTHOR));
                book.setPrice(result.getInt(PRICE));
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find book by title. %s", e));
            throw new DaoException("Error while attempting to find book by title: " + e.getMessage());
        }
        return book;
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BOOKS)) {
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                Author author = new Author();
                author.setAuthorId(result.getInt(AUTHOR_ID));
                author.setFirstName(result.getString(FIRSTNAME));
                author.setLastName(result.getString(LASTNAME));
                Book book = new Book();
                book.setBookId(result.getInt(BOOK_ID));
                book.setTitle(result.getString(TITLE));
                book.setPrice(result.getInt(PRICE));
                book.setAuthor(author);
                allBooks.add(book);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find all books. %s", e));
            throw new DaoException("Error while attempting to find all books: " + e.getMessage());
        }
        return allBooks;
    }

    @Override
    public List<Book> findAllBooksByAuthor(Author author) {
        List<Book> allBooks = new ArrayList<>();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BOOKS_BY_AUTHOR)) {
            statement.setInt(1, author.getAuthorId());
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                Book book = new Book();
                book.setBookId(result.getInt(BOOK_ID));
                book.setTitle(result.getString(TITLE));
//                book.setAuthorId(result.getInt(AUTHOR));
                book.setPrice(result.getInt(PRICE));
                allBooks.add(book);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find all books by author. %s", e));
            throw new DaoException("Error while attempting to find all books by author: " + e.getMessage());
        }
        return allBooks;
    }

    @Override
    public List<Book> findAllBooksByStore(Store store) {
        List<Book> allBooks = new ArrayList<>();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BOOKS_IN_STORE)) {
            statement.setInt(1, store.getStoreId());
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                Book book = new Book();
                book.setBookId(result.getInt(BOOK_ID));
//                book.setTitle(result.getString(TITLE));
//                book.setAuthorId(result.getInt(AUTHOR));
                book.setPrice(result.getInt(PRICE));
                allBooks.add(book);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find all books in store. %s", e));
            throw new DaoException("Error while attempting to find all books in store: " + e.getMessage());
        }
        return allBooks;
    }
}
