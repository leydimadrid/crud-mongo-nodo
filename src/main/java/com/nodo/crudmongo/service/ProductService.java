package com.nodo.crudmongo.service;

import com.nodo.crudmongo.domain.Product;
import com.nodo.crudmongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Objeto de tipo servicio
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void createProduct(Product product) {
        Product newProduct = new Product(
                product.getId(),
                product.getTitle(),
                product.getImgPath(),
                product.getDescription()
        );
        productRepository.save(newProduct);


    }

    public void updateProduct(long productId, Product product) {
        Product productt = productRepository.findById(productId).orElse(null);
        if (productt != null) {
            productt.setTitle(product.getTitle());
            productt.setImgPath(product.getImgPath());
            productt.setDescription(product.getDescription());
            productRepository.save(productt);
        }

    }

    public void deleteProduct(long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            productRepository.delete(product);
        }
    }
}
