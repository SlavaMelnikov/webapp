package by.melnikov.webapp.dao.impl;

import by.melnikov.webapp.connection.DataSource;
import by.melnikov.webapp.dao.AuthorDao;
import by.melnikov.webapp.entity.Author;
import by.melnikov.webapp.entity.Book;
import by.melnikov.webapp.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.melnikov.webapp.util.ColumnNames.*;
import static by.melnikov.webapp.util.query.AuthorSqlQuery.*;

public class AuthorDaoImpl implements AuthorDao {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public int addAuthor(Author author) {
        int addedAuthorId = -1;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_AUTHOR, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            result.next();
            addedAuthorId = result.getInt("author_id");
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to add new authorId. %s", e));
            throw new DaoException("Error while attempting to add new authorId: " + e.getMessage());
        }
        return addedAuthorId;
    }

    @Override
    public void removeAuthor(Author author) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_AUTHOR)) {
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to remove authorId. %s", e));
            throw new DaoException("Error while attempting to remove authorId: " + e.getMessage());
        }
    }

    @Override
    public void removeAuthorById(int id) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_AUTHOR_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to remove authorId by id. %s", e));
            throw new DaoException("Error while attempting to remove authorId by id: " + e.getMessage());
        }
    }

    @Override
    public Author findAuthorById(int id) {
        Author author = new Author();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_AUTHOR_BY_ID)) {
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                author.setFirstName(result.getString(FIRSTNAME));
                author.setLastName(result.getString(LASTNAME));
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find authorId by id. %s", e));
            throw new DaoException("Error while attempting to find authorId by id: " + e.getMessage());
        }
        return author;
    }

    @Override
    public int findAuthorId(Author author) {
        int foundAuthorId = -1;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_AUTHOR_ID)) {
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.execute();
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                foundAuthorId = result.getInt("author_id");
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find author id. %s", e));
            throw new DaoException("Error while attempting to find author id: " + e.getMessage());
        }
        return foundAuthorId;
    }

    @Override
    public Author findAuthorByBook(Book book) {
        Author author = new Author();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_AUTHOR_BY_BOOK)) {
            statement.setString(1, book.getTitle());
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                author.setAuthorId(result.getInt(AUTHOR_ID));
                author.setFirstName(result.getString(FIRSTNAME));
                author.setLastName(result.getString(LASTNAME));
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find authorId by book. %s", e));
            throw new DaoException("Error while attempting to find authorId by book: " + e.getMessage());
        }
        return author;
    }

    @Override
    public List<Author> findAllAuthors() {
        List<Author> allAuthors = new ArrayList<>();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_AUTHORS)) {
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                Author author = new Author();
                author.setAuthorId(result.getInt(AUTHOR_ID));
                author.setFirstName(result.getString(FIRSTNAME));
                author.setLastName(result.getString(LASTNAME));
                allAuthors.add(author);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find all authors. %s", e));
            throw new DaoException("Error while attempting to find all authors: " + e.getMessage());
        }
        return allAuthors;
    }
}
