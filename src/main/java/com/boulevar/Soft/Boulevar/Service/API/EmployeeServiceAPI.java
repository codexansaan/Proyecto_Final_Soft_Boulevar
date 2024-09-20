package com.boulevar.Soft.Boulevar.Service.API;

import com.boulevar.Soft.Boulevar.Commons.GenericServiceAPI;
import com.boulevar.Soft.Boulevar.models.Employee;

import java.util.List;

public interface EmployeeServiceAPI extends GenericServiceAPI<Employee, Integer> {

    List<Employee> getAll();

}
