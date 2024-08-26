package com.boulevar.Soft.Boulevar.Impl;

import com.boulevar.Soft.Boulevar.Dao.API.EmpleadoDaoAPI;
import com.boulevar.Soft.Boulevar.Service.API.EmpleadoServiceAPI;
import com.boulevar.Soft.Boulevar.Commons.GenericServiceImpl;
import com.boulevar.Soft.Boulevar.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements EmpleadoServiceAPI {

    @Autowired
    private EmpleadoDaoAPI empleadoDaoAPI;

    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return empleadoDaoAPI;
    }
}
