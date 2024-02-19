package com.example.springcrudapp.service;


import com.example.springcrudapp.entity.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product insertProductIntoDatabase(Product product);

    Product getProductById(int id );

    Product updateProduct(int id, Product product);

    Product deleteProduct(int id);


}
