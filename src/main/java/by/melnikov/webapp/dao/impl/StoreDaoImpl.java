package by.melnikov.webapp.dao.impl;

import by.melnikov.webapp.connection.DataSource;
import by.melnikov.webapp.dao.StoreDao;
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
import static by.melnikov.webapp.util.query.StoreSqlQuery.*;

public class StoreDaoImpl implements StoreDao {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void addStore(Store store) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_STORE)) {
            statement.setInt(1, store.getStoreId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to add new store. %s", e));
            throw new DaoException("Error while attempting to add new store: " + e.getMessage());
        }
    }

    @Override
    public void removeStoreById(int id) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_STORE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to remove store by id. %s", e));
            throw new DaoException("Error while attempting to remove store by id: " + e.getMessage());
        }
    }

    @Override
    public Store findStoreById(int id) {
        Store store = new Store();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_STORE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                store.setAddressId(result.getInt(ADDRESS));
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find store by id. %s", e));
            throw new DaoException("Error while attempting to find store by id: " + e.getMessage());
        }
        return store;
    }

    @Override
    public List<Store> findAllStores() {
        List<Store> allStores = new ArrayList<>();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_STORES)) {
            statement.executeQuery();
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                Store store = new Store();
                store.setStoreId(result.getInt(STORE_ID));
                store.setAddressId(result.getInt(ADDRESS));
                allStores.add(store);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to find all stores. %s", e));
            throw new DaoException("Error while attempting to find all stores: " + e.getMessage());
        }
        return allStores;
    }
}
