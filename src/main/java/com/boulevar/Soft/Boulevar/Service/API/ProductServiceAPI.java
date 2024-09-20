package com.boulevar.Soft.Boulevar.Service.API;

import com.boulevar.Soft.Boulevar.Commons.GenericServiceAPI;
import com.boulevar.Soft.Boulevar.Projection.InterfaceBased.Closed.ProductClosedView;
import com.boulevar.Soft.Boulevar.models.Product;

import java.util.List;

public interface ProductServiceAPI extends GenericServiceAPI<Product, Integer> {

    List<Product> getAll();

    List<ProductClosedView> findBy();
}
