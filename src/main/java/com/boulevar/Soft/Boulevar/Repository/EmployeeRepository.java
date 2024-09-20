package com.boulevar.Soft.Boulevar.Repository;

import com.boulevar.Soft.Boulevar.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



}
