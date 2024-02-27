package by.melnikov.webapp.dao;

import by.melnikov.webapp.entity.Store;

import java.util.List;

public interface StoreDao {
    void addStore(Store store);
    void removeStoreById(int id);
    Store findStoreById(int id);
    List<Store> findAllStores();
}
