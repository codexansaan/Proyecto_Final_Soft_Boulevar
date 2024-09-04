package com.boulevar.Soft.Boulevar.Impl;

import com.boulevar.Soft.Boulevar.Commons.GenericServiceImpl;
import com.boulevar.Soft.Boulevar.Dao.API.ProductoDaoAPI;
import com.boulevar.Soft.Boulevar.Service.API.ProductoServiceAPI;
import com.boulevar.Soft.Boulevar.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements ProductoServiceAPI {

    @Autowired
    private ProductoDaoAPI productoDaoAPI;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoDaoAPI;
    }
}
