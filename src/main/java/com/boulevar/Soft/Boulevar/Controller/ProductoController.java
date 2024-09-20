package com.boulevar.Soft.Boulevar.Controller;


import com.boulevar.Soft.Boulevar.Service.API.ProductoServiceAPI;
import com.boulevar.Soft.Boulevar.Util.ApiRespuestaData;
import com.boulevar.Soft.Boulevar.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    private ProductoServiceAPI productoServiceAPI;

    @GetMapping("/")
    public ApiRespuestaData<List<Producto>> getAllProductos() {
        List<Producto> productos = productoServiceAPI.getAll();

        return new ApiRespuestaData<>(productos);
    }

    @GetMapping("/show/{id}")
    public ApiRespuestaData<Producto> getProductoById(@PathVariable("id")Integer id) {
        Producto producto = (id != null && id != 0) ? productoServiceAPI.get(id) : new Producto();
          return new ApiRespuestaData<>(producto);
    }

    @PostMapping("/save")
    public ApiRespuestaData<Producto> saveProducto(@RequestBody Producto producto){
        Producto savedEmpleado = productoServiceAPI.save(producto);

        return new ApiRespuestaData<>(producto);

    }

    @DeleteMapping("delete/{id}")
    public ApiRespuestaData<String> delete(@PathVariable Integer id){
        productoServiceAPI.deleted(id);
        return new ApiRespuestaData<>("Producto Eliminado con exito");
    }

}
