package by.melnikov.webapp.util.query;

public class AuthorSqlQuery {
    private AuthorSqlQuery() {
    }

    public static final String ADD_AUTHOR = """
                                                INSERT INTO author (firstname, lastname)
                                                VALUES (?, ?)
                                            """;
    public static final String REMOVE_AUTHOR = """
                                                   DELETE FROM author
                                                   WHERE firstname = ?
                                                     AND lastname = ?
                                               """;

    public static final String REMOVE_AUTHOR_BY_ID = """
                                                        DELETE FROM author
                                                        WHERE author_id = ?
                                                     """;
    public static final String FIND_AUTHOR_BY_ID = """
                                                      SELECT firstname, lastname FROM author
                                                      WHERE author_id = ?
                                                   """;
    public static final String FIND_AUTHOR_ID = """
                                                        SELECT author_id FROM author
                                                        WHERE firstname = ?
                                                          AND lastname = ?
                                                     """;
    public static final String FIND_AUTHOR_BY_BOOK = """
                                                        SELECT a.firstname, a.lastname
                                                        FROM book b
                                                        JOIN author a ON b.author = a.author_id
                                                        WHERE b.title = ?;
                                                     """;
    public static final String FIND_ALL_AUTHORS = """
                                                     SELECT * FROM author
                                                  """;
}
