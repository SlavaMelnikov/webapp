package by.melnikov.webapp.service.impl;

import by.melnikov.webapp.dao.AuthorDao;
import by.melnikov.webapp.dao.impl.AuthorDaoImpl;
import by.melnikov.webapp.entity.Author;
import by.melnikov.webapp.entity.Book;
import by.melnikov.webapp.service.AuthorService;
import by.melnikov.webapp.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private static final Logger logger = LogManager.getLogger();
    public static final AuthorService INSTANCE = new AuthorServiceImpl();

    private AuthorDao authorDao = new AuthorDaoImpl();

    private AuthorServiceImpl() {
    }

    @Override
    public int addAuthor(Author author) {
        int authorId = authorDao.findAuthorId(author);
        if (authorId == -1) {
            authorId = authorDao.addAuthor(author);
        }
        return authorId;
    }

    @Override
    public void removeAuthor(Author author) {
        this.authorDao.removeAuthor(author);
    }

    @Override
    public void removeAuthorById(int id) {
        this.authorDao.removeAuthorById(id);
    }

    @Override
    public Author findAuthorById(int id) {
        return null;
    }

    @Override
    public int findAuthorId(Author author) {
        return authorDao.findAuthorId(author);
    }
    @Override
    public Author findAuthorByBook(Book book) {
        return null;
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorDao.findAllAuthors();
    }
}
