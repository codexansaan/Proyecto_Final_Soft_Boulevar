package com.boulevar.Soft.Boulevar.Controller;


import com.boulevar.Soft.Boulevar.Service.API.RawMaterialServiceAPI;
import com.boulevar.Soft.Boulevar.models.RawMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/materiaprima")
@CrossOrigin("*")

public class RawMaterialController {

    @Autowired
    private RawMaterialServiceAPI rawMaterialServiceAPI;

    @GetMapping("/")
    public List<RawMaterial> getAllMateriaPrima(){return rawMaterialServiceAPI.getAll();}

    @GetMapping("/show/{id}")
    public RawMaterial getMateriaPrimaById(@PathVariable("id")Integer id) {
        if (id !=null && id !=0){
            return rawMaterialServiceAPI.get(id);
        } else {
            return new RawMaterial();
        }
    }

    @PostMapping("/save")
    public RawMaterial saveMateriaPrima(@RequestBody RawMaterial rawMaterial){return rawMaterialServiceAPI.save(rawMaterial);}

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        rawMaterialServiceAPI.deleted(id);
        return "Materia Prima eliminada con éxito";
    }

}
