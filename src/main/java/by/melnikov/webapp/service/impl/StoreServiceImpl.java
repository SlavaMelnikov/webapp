package by.melnikov.webapp.service.impl;

import by.melnikov.webapp.dao.StoreDao;
import by.melnikov.webapp.dao.impl.StoreDaoImpl;
import by.melnikov.webapp.entity.Store;
import by.melnikov.webapp.service.StoreService;

import java.util.List;

public class StoreServiceImpl implements StoreService {
    public static StoreServiceImpl INSTANCE= new StoreServiceImpl();
    private StoreDao storeDao = new StoreDaoImpl();

    private StoreServiceImpl() {
    }
    @Override
    public void addStore(Store store) {

    }

    @Override
    public void removeStoreById(int id) {

    }

    @Override
    public Store findStoreById(int id) {
        return null;
    }

    @Override
    public List<Store> findAllStores() {
        return storeDao.findAllStores();
    }
}
