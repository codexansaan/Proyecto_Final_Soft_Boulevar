package com.boulevar.Soft.Boulevar.Service.API;

import com.boulevar.Soft.Boulevar.Commons.GenericServiceAPI;
import com.boulevar.Soft.Boulevar.models.RawMaterial;

import java.util.List;


public interface RawMaterialServiceAPI extends GenericServiceAPI<RawMaterial, Integer> {

    List<RawMaterial> getAll();
}
