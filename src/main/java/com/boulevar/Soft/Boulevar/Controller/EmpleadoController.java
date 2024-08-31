package com.boulevar.Soft.Boulevar.Controller;

import com.boulevar.Soft.Boulevar.Service.API.EmpleadoServiceAPI;
import com.boulevar.Soft.Boulevar.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceAPI empleadoServiceAPI;

    @GetMapping("/")
    public List<Empleado> getAllEmpleados() {
        return empleadoServiceAPI.getAll();
    }

    @GetMapping("/show/{id}")
    public Empleado getEmpleadoById(@PathVariable("id") Integer id) {
        if (id != null && id != 0) {
            return empleadoServiceAPI.get(id);
        } else {
            return new Empleado();
        }
    }

    @PostMapping("/save")
    public Empleado saveEmpleado(@RequestBody Empleado empleado) {
        return empleadoServiceAPI.save(empleado);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        empleadoServiceAPI.deleted(id);
        return "Empleado eliminado con éxito";
    }

}
