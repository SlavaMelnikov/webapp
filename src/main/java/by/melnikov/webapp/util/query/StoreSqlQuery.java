package by.melnikov.webapp.util.query;

public class StoreSqlQuery {
    private StoreSqlQuery() {
    }

    public static final String ADD_STORE = """
                                              INSERT INTO store (address)
                                              VALUES (?)
                                           """;
    public static final String REMOVE_STORE_BY_ID = """
                                                       DELETE FROM store
                                                       WHERE store_id = ?
                                                    """;
    public static final String FIND_STORE_BY_ID = """
                                                     SELECT address FROM store
                                                     WHERE store_id = ?
                                                  """;
    public static final String FIND_ALL_STORES = """
                                                    SELECT * FROM store
                                                 """;
}
