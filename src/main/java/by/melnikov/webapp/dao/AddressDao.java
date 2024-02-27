package by.melnikov.webapp.dao;

import by.melnikov.webapp.entity.Address;

public interface AddressDao {
    void addAddress(Address address);
    void removeAddress(Address address);
    void removeAddressById(int id);
}
