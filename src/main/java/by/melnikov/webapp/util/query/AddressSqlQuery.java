package by.melnikov.webapp.util.query;

public class AddressSqlQuery {

    private AddressSqlQuery() {
    }


    public static final String ADD_ADDRESS = """
                                                INSERT INTO address (city, street, building)
                                                VALUES (?, ?, ?)
                                             """;
    public static final String REMOVE_ADDRESS = """
                                                    DELETE FROM address
                                                    WHERE city = ?
                                                      AND street = ?
                                                      AND building = ?
                                                """;
    public static final String REMOVE_ADDRESS_BY_ID = """
                                                         DELETE FROM address
                                                         WHERE address_id = ?
                                                      """;

}
