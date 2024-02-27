package by.melnikov.webapp.util.query;

public class BookSqlQuery {
    private BookSqlQuery() {
    }

    public static final String ADD_BOOK = """
                                             INSERT INTO book (title, author, price)
                                             VALUES (?, ?, ?)
                                          """;
    public static final String UPDATE_BOOK_PRICE = """
                                                      UPDATE book
                                                      SET price = ?
                                                      WHERE book_id = ?
                                                   """;
    public static final String REMOVE_BOOK_BY_ID = """
                                                      DELETE FROM book
                                                      WHERE book_id = ?
                                                   """;

    public static final String REMOVE_BOOK_BY_TITLE = """
                                                         DELETE FROM book
                                                         WHERE title = ?
                                                      """;
    public static final String FIND_BOOK_BY_ID = """
                                                    SELECT title, author, price FROM book
                                                    WHERE book_id = ?
                                                 """;
    public static final String FIND_BOOK_BY_TITLE = """
                                                       SELECT a.firstname, a.lastname
                                                       FROM book b
                                                       JOIN author a ON b.author = a.author_id
                                                       WHERE b.title = ?;
                                                    """;
    public static final String FIND_ALL_BOOKS = """
                                                   SELECT b.book_id, b.title, b.price, a.author_id, a.firstname, a.lastname
                                                   FROM book b
                                                   INNER JOIN author a ON b.author = a.author_id
                                                """;
    public static final String FIND_ALL_BOOKS_BY_AUTHOR = """
                                                             SELECT * FROM book
                                                             WHERE author = ?
                                                          """;
    public static final String FIND_ALL_BOOKS_IN_STORE = """
                                                            SELECT book.* FROM store_has_books
                                                            JOIN book ON store_has_books.book_id = book.book_id
                                                            WHERE store_has_books.store_id = ?
                                                         """;
}
