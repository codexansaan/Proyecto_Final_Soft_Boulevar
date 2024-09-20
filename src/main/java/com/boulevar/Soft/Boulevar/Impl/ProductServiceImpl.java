package com.boulevar.Soft.Boulevar.Impl;

import com.boulevar.Soft.Boulevar.Commons.GenericServiceImpl;
import com.boulevar.Soft.Boulevar.Projection.InterfaceBased.Closed.ProductClosedView;
import com.boulevar.Soft.Boulevar.Repository.ProductRepository;
import com.boulevar.Soft.Boulevar.Service.API.ProductServiceAPI;
import com.boulevar.Soft.Boulevar.models.Employee;
import com.boulevar.Soft.Boulevar.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductServiceAPI {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CrudRepository<Product, Integer> getDao() {
        return productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @Override
    public List<ProductClosedView> findBy() {
        return productRepository.findBy();
    }
}
