package by.melnikov.webapp.connection;

import by.melnikov.webapp.exception.ConnectionException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static final Logger logger = LogManager.getLogger();
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        ds = new HikariDataSource(config);
    }

    private DataSource() {}

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Error during getting connection");
            throw new ConnectionException("Can't get connection: " + e.getMessage());
        }
    }
}
