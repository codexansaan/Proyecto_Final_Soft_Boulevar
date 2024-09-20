package com.boulevar.Soft.Boulevar.Repository;

import com.boulevar.Soft.Boulevar.models.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Integer> {


}
