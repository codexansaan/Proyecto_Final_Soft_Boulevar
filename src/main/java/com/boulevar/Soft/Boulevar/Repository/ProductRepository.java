package com.boulevar.Soft.Boulevar.Repository;

import com.boulevar.Soft.Boulevar.Projection.InterfaceBased.Closed.ProductClosedView;
import com.boulevar.Soft.Boulevar.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Trae le lista de productos solo con lo especificado.
    List<ProductClosedView> findBy();

}
