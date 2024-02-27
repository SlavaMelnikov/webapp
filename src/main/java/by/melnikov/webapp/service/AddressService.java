package by.melnikov.webapp.service;

import by.melnikov.webapp.entity.Address;

public interface AddressService {
    void addAddress(Address address);
    void removeAddress(Address address);
    void removeAddressById(int id);
}
