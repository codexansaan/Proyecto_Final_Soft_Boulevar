package com.boulevar.Soft.Boulevar.Impl;

import com.boulevar.Soft.Boulevar.Repository.EmployeeRepository;
import com.boulevar.Soft.Boulevar.Service.API.EmployeeServiceAPI;
import com.boulevar.Soft.Boulevar.Commons.GenericServiceImpl;
import com.boulevar.Soft.Boulevar.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Integer> implements EmployeeServiceAPI {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public CrudRepository<Employee, Integer> getDao() {
        return employeeRepository;
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
