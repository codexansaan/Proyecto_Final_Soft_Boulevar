package com.boulevar.Soft.Boulevar.Controller;

import com.boulevar.Soft.Boulevar.Service.API.EmpleadoServiceAPI;
import com.boulevar.Soft.Boulevar.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceAPI empleadoServiceAPI;

    @RequestMapping ("empleados")
    public String index(Model model) {
        model.addAttribute("list", empleadoServiceAPI.getAll());
        return "index";
    }
    @GetMapping("/save{id}")
    public String ShowSave(@PathVariable("Id") Integer id, Model model) {
        if (id != null){
            model.addAttribute("empleado", empleadoServiceAPI.get(id));
        }
        return "Save";
    }

    @PostMapping("/save")
    public String save(Empleado empleado, Model model) {
        empleadoServiceAPI.save(empleado);
        return "redirect:/";
    }


    public String delete(@PathVariable Integer id, Model model) {
        empleadoServiceAPI.deleted(id);
        return "redirect:/";
    }


}
