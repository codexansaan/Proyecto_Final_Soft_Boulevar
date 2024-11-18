package com.boulevar.Soft.Boulevar.Impl;

import com.boulevar.Soft.Boulevar.Commons.GenericServiceImpl;
import com.boulevar.Soft.Boulevar.Repository.RawMaterialRepository;
import com.boulevar.Soft.Boulevar.Service.API.RawMaterialServiceAPI;
import com.boulevar.Soft.Boulevar.models.RawMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service

public class RawMaterialServiceImpl extends GenericServiceImpl<RawMaterial, Integer> implements RawMaterialServiceAPI {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @Override
    public CrudRepository<RawMaterial, Integer> getDao(){return rawMaterialRepository;}
}
