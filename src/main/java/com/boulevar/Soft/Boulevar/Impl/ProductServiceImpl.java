package com.boulevar.Soft.Boulevar.Impl;

import com.boulevar.Soft.Boulevar.Commons.GenericServiceImpl;
import com.boulevar.Soft.Boulevar.Dao.API.ProductDaoAPI;
import com.boulevar.Soft.Boulevar.Service.API.ProductServiceAPI;
import com.boulevar.Soft.Boulevar.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductServiceAPI {

    @Autowired
    private ProductDaoAPI productDaoAPI;

    @Override
    public CrudRepository<Product, Integer> getDao() {
        return productDaoAPI;
    }
}
