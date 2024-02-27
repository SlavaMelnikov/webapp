package by.melnikov.webapp.service.impl;

import by.melnikov.webapp.dao.AuthorDao;
import by.melnikov.webapp.dao.BookDao;
import by.melnikov.webapp.dao.impl.AuthorDaoImpl;
import by.melnikov.webapp.dao.impl.BookDaoImpl;
import by.melnikov.webapp.entity.Author;
import by.melnikov.webapp.entity.Book;
import by.melnikov.webapp.entity.Store;
import by.melnikov.webapp.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BookServiceImpl implements BookService {
    private static final Logger logger = LogManager.getLogger();
    public static final BookService INSTANCE = new BookServiceImpl();
    private BookDao bookDao = new BookDaoImpl();
    private AuthorDao authorDao = new AuthorDaoImpl();

    private BookServiceImpl() {
    }

    @Override
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    public void updateBookPrice(int id, int price) {
        this.bookDao.updateBookPrice(id, price);
    }

    @Override
    public void removeBookById(int id) {
        this.bookDao.removeBookById(id);
    }

    @Override
    public void removeBookByTitle(String title) {
        this.bookDao.removeBookByTitle(title);
    }

    @Override
    public Book findBookById(int id) {
        return null;
    }

    @Override
    public Book findBookByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        return this.bookDao.findAllBooks();
    }

    @Override
    public List<Book> findAllBooksByAuthor(Author author) {
        return null;
    }

    @Override
    public List<Book> findAllBooksByStore(Store store) {
        return null;
    }
}
