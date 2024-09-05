package com.boulevar.Soft.Boulevar.Impl;

import com.boulevar.Soft.Boulevar.Commons.GenericServiceImpl;
import com.boulevar.Soft.Boulevar.Dao.API.MateriaPrimaDaoAPI;
import com.boulevar.Soft.Boulevar.Service.API.MateriaPrimaServiceAPI;
import com.boulevar.Soft.Boulevar.models.MateriaPrima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service

public class MateriaPrimaServiceImpl extends GenericServiceImpl<MateriaPrima, Integer> implements MateriaPrimaServiceAPI {

    @Autowired
    private MateriaPrimaDaoAPI materiaPrimaDaoAPI;

    @Override
    public CrudRepository<MateriaPrima, Integer> getDao(){return materiaPrimaDaoAPI;}
}
