package by.melnikov.webapp.service.impl;

import by.melnikov.webapp.dao.AddressDao;
import by.melnikov.webapp.dao.impl.AddressDaoImpl;
import by.melnikov.webapp.entity.Address;
import by.melnikov.webapp.service.AddressService;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao;

    public AddressServiceImpl() {
        this.addressDao =  new AddressDaoImpl();
    }

    @Override
    public void addAddress(Address address) {
        this.addressDao.addAddress(address);
    }

    @Override
    public void removeAddress(Address address) {
        this.addressDao.removeAddress(address);
    }

    @Override
    public void removeAddressById(int id) {
        if (id > 0) {
            this.addressDao.removeAddressById(id);
        }
    }
}
