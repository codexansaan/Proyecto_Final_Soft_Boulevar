package com.boulevar.Soft.Boulevar.Controller;

import com.boulevar.Soft.Boulevar.Service.API.EmployeeServiceAPI;
import com.boulevar.Soft.Boulevar.Util.ApiResponseData;
import com.boulevar.Soft.Boulevar.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeServiceAPI employeeServiceAPI;

    @GetMapping("/")
    public ApiResponseData<List<Employee>> getAllEmpleados() {
        List<Employee> employees = employeeServiceAPI.getAll();

        return new ApiResponseData<>(employees);

    }

    @GetMapping("/show/{id}")
    public ApiResponseData<Employee> getEmpleadoById(@PathVariable("id") Integer id) {
        Employee employee = (id != null && id != 0) ? employeeServiceAPI.get(id) : new Employee();
        return new ApiResponseData<>(employee);
    }

    @PostMapping("/save")
    public ApiResponseData<Employee> saveEmpleado(@RequestBody Employee employee) {
        Employee savedEmployee = employeeServiceAPI.save(employee);
        return new ApiResponseData<>(savedEmployee);
    }

    @DeleteMapping("delete/{id}")
    public ApiResponseData<String> delete(@PathVariable Integer id) {
        employeeServiceAPI.deleted(id);
        return new ApiResponseData<>("Empleado eliminado con éxito");
    }



}
