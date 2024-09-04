package com.boulevar.Soft.Boulevar.Controller;


import com.boulevar.Soft.Boulevar.Service.API.ProductoServiceAPI;
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
    public List<Producto> getAllProductos() {
        return productoServiceAPI.getAll();
    }

    @GetMapping("/show/{id}")
    public Producto getProductoById(@PathVariable("id")Integer id) {
        if (id != null && id != 0) {
            return productoServiceAPI.get(id);
        } else {
            return new Producto();
        }
    }

    @PostMapping("/save")
    public Producto saveProducto(@RequestBody Producto producto){
        return productoServiceAPI.save(producto);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        productoServiceAPI.deleted(id);
        return "Producto Eliminado con exito";
    }

}
