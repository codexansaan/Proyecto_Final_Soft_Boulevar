package com.boulevar.Soft.Boulevar.Controller;

import com.boulevar.Soft.Boulevar.Service.API.RawMaterialServiceAPI;
import com.boulevar.Soft.Boulevar.Util.ApiResponseData;
import com.boulevar.Soft.Boulevar.models.RawMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rawmaterial")
@CrossOrigin("*")

public class RawMaterialController {

    @Autowired
    private RawMaterialServiceAPI rawMaterialServiceAPI;

    @GetMapping("/")
    public ApiResponseData<List<RawMaterial>> getallRawMaterial() {
        List<RawMaterial> rawMaterial = rawMaterialServiceAPI.getAll();

        return new ApiResponseData<>(rawMaterial);
    }
    @GetMapping("/show/{id}")
    public ApiResponseData<RawMaterial> getRawMaterialById(@PathVariable("id")Integer id) {
        RawMaterial rawMaterial = (id != null && id != 0) ? rawMaterialServiceAPI.get(id): new RawMaterial();
        return new ApiResponseData<>(rawMaterial);
    }

    @PostMapping("/save")
    public ApiResponseData<RawMaterial> saveRawMaterial(@RequestBody RawMaterial rawMaterial){
        RawMaterial savedRawMaterial = rawMaterialServiceAPI.save(rawMaterial);

        return new ApiResponseData<>(savedRawMaterial);

    }

    @DeleteMapping("delete/{id}")
    public ApiResponseData<String> delete(@PathVariable Integer id){
        rawMaterialServiceAPI.deleted(id);
        return new ApiResponseData<>("Materia prima eliminada con éxito");
    }

}
