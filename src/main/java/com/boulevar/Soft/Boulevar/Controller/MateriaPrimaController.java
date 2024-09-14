package com.boulevar.Soft.Boulevar.Controller;


import com.boulevar.Soft.Boulevar.Service.API.MateriaPrimaServiceAPI;
import com.boulevar.Soft.Boulevar.models.MateriaPrima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/materiaprima")
@CrossOrigin("*")

public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaServiceAPI materiaPrimaServiceAPI;

    @GetMapping("/")
    public List<MateriaPrima> getAllMateriaPrima(){return materiaPrimaServiceAPI.getAll();}

    @GetMapping("/show/{id}")
    public MateriaPrima getMateriaPrimaById(@PathVariable("id")Integer id) {
        if (id !=null && id !=0){
            return materiaPrimaServiceAPI.get(id);
        } else {
            return new MateriaPrima();
        }
    }

    @PostMapping("/save")
    public MateriaPrima saveMateriaPrima(@RequestBody MateriaPrima materiaPrima){return materiaPrimaServiceAPI.save(materiaPrima);}

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        materiaPrimaServiceAPI.deleted(id);
        return "Materia Prima eliminada con éxito";
    }

}
