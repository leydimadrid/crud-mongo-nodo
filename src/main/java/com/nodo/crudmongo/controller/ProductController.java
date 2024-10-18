package com.nodo.crudmongo.controller;

import com.nodo.crudmongo.domain.Product;
import com.nodo.crudmongo.repository.ProductRepository;
import com.nodo.crudmongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/getProducts", produces = "application/json")
    public List<Product> getProducts() { //Se invoca el metodo getProducts
        return productService.getProducts(); //Ejecutar instrucción
    }

    @PostMapping(value = "/newProduct")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        productService.createProduct(product);//CreateProduct, metodo de la clase ProductService
        return new ResponseEntity(HttpStatus.CREATED); //Status code 201
    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity updateProduct(@PathVariable int productId, @RequestBody Product product) {
        productService.updateProduct(productId, product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
