package com.boulevar.Soft.Boulevar.Controller;

import com.boulevar.Soft.Boulevar.Service.API.EmpleadoServiceAPI;
import com.boulevar.Soft.Boulevar.Util.ApiRespuestaData;
import com.boulevar.Soft.Boulevar.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/empleados")
@CrossOrigin("*")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceAPI empleadoServiceAPI;

    @GetMapping("/")
    public ApiRespuestaData<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoServiceAPI.getAll();

        return new ApiRespuestaData<>(empleados);

    }

    @GetMapping("/show/{id}")
    public ApiRespuestaData<Empleado> getEmpleadoById(@PathVariable("id") Integer id) {
        Empleado empleado = (id != null && id != 0) ? empleadoServiceAPI.get(id) : new Empleado();
        return new ApiRespuestaData<>(empleado);
    }

    @PostMapping("/save")
    public ApiRespuestaData<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = empleadoServiceAPI.save(empleado);
        return new ApiRespuestaData<>(savedEmpleado);
    }

    @DeleteMapping("delete/{id}")
    public ApiRespuestaData<String> delete(@PathVariable Integer id) {
        empleadoServiceAPI.deleted(id);
        return new ApiRespuestaData<>("Empleado eliminado con éxito");
    }

}
