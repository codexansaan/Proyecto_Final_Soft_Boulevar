package com.boulevar.Soft.Boulevar.Controller;


import com.boulevar.Soft.Boulevar.Service.API.MateriaPrimaServiceAPI;
import com.boulevar.Soft.Boulevar.Util.ApiRespuestaData;
import com.boulevar.Soft.Boulevar.models.MateriaPrima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiaprima")
@CrossOrigin("*")

public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaServiceAPI materiaPrimaServiceAPI;

    @GetMapping("/")
    public ApiRespuestaData<List<MateriaPrima>> getAllMateriaPrima() {
        List<MateriaPrima> materiaPrimas = materiaPrimaServiceAPI.getAll();

        return new ApiRespuestaData<>(materiaPrimas);
    }

    @GetMapping("/show/{id}")
    public ApiRespuestaData<MateriaPrima> getMateriaPrimaById(@PathVariable("id")Integer id) {
        MateriaPrima materiaPrima = (id != null && id != 0) ? materiaPrimaServiceAPI.get(id) : new MateriaPrima();
            return new ApiRespuestaData<>(materiaPrima);
    }

    @PostMapping("/save")
    public ApiRespuestaData<MateriaPrima> saveMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
        MateriaPrima savedMateriaPrima = materiaPrimaServiceAPI.save(materiaPrima);
        return new ApiRespuestaData<>(savedMateriaPrima);
    }

    @DeleteMapping("/delete/{id}")
    public ApiRespuestaData<String> delete(@PathVariable Integer id){
        materiaPrimaServiceAPI.deleted(id);
        return new ApiRespuestaData<>("Materia Prima eliminada con éxito");
    }

}
