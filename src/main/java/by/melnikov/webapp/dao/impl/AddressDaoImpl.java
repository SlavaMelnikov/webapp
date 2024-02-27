package by.melnikov.webapp.dao.impl;

import by.melnikov.webapp.connection.DataSource;
import by.melnikov.webapp.dao.AddressDao;
import by.melnikov.webapp.entity.Address;
import by.melnikov.webapp.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.melnikov.webapp.util.query.AddressSqlQuery.*;

public class AddressDaoImpl implements AddressDao {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void addAddress(Address address) {
        try (Connection connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_ADDRESS)) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setString(3, address.getBuilding());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to add new address. %s", e));
            throw new DaoException("Error while attempting to add new address: " + e.getMessage());
        }
    }

    @Override
    public void removeAddress(Address address) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_ADDRESS)) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setString(3, address.getBuilding());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to remove address. %s", e));
            throw new DaoException("Error while attempting to remove address: " + e.getMessage());
        }
    }

    @Override
    public void removeAddressById(int id) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_ADDRESS_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, String.format("Error while attempting to remove address by id. %s", e));
            throw new DaoException("Error while attempting to remove address by id: " + e.getMessage());
        }
    }
}
