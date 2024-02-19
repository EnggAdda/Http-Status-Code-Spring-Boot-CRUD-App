package com.example.springcrudapp.controller;

import com.example.springcrudapp.entity.Product;
import com.example.springcrudapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProductsController() {
       List<Product> allProducts=  productService.getAllProducts();
      return   ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }


    @PostMapping("/insert")
    public ResponseEntity<Product> insertProductInDb(@RequestBody Product product) {
        Product productInserted  =  productService.insertProductIntoDatabase(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productInserted);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product p =  productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable int id,@RequestBody Product product) {
       Product p  = productService.updateProduct(id,product);
     return    ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable int id) {
       Product p = productService.deleteProduct(id);
        return    ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


    @GetMapping("/test")
    public ResponseEntity<String> test() {

        return   ResponseEntity.status(HttpStatus.SWITCHING_PROTOCOLS).body("SWITCHING_PROTOCOLS");
    }

}
