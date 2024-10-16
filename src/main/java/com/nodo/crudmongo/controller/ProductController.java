package com.nodo.crudmongo.controller;

import com.nodo.crudmongo.domain.Product;
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
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @PostMapping(value = "/newProduct")
  public ResponseEntity saveProduct(@RequestBody Product product) {
    productService.createProduct(product);
    return new ResponseEntity(HttpStatus.CREATED);
  }
}
