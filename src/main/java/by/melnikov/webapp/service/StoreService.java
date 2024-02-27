package by.melnikov.webapp.service;

import by.melnikov.webapp.entity.Store;

import java.util.List;

public interface StoreService {
    void addStore(Store store);
    void removeStoreById(int id);
    Store findStoreById(int id);
    List<Store> findAllStores();
}
