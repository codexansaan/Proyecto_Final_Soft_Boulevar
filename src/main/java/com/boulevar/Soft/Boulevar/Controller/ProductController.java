package com.boulevar.Soft.Boulevar.Controller;


import com.boulevar.Soft.Boulevar.Service.API.ProductServiceAPI;
import com.boulevar.Soft.Boulevar.Util.ApiResponseData;
import com.boulevar.Soft.Boulevar.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductServiceAPI productServiceAPI;

    @GetMapping("/")
    public ApiResponseData<List<Product>> getAllProductos() {
        List<Product> products = productServiceAPI.getAll();

        return new ApiResponseData<>(products);
    }

    @GetMapping("/show/{id}")
    public ApiResponseData<Product> getProductoById(@PathVariable("id")Integer id) {
        Product product = (id != null && id != 0) ? productServiceAPI.get(id) : new Product();
          return new ApiResponseData<>(product);
    }

    @PostMapping("/save")
    public ApiResponseData<Product> saveProducto(@RequestBody Product product){
        Product savedEmpleado = productServiceAPI.save(product);

        return new ApiResponseData<>(product);

    }

    @DeleteMapping("delete/{id}")
    public ApiResponseData<String> delete(@PathVariable Integer id){
        productServiceAPI.deleted(id);
        return new ApiResponseData<>("Producto Eliminado con exito");
    }

}
