package com.example.quan_lyban_hang_angular.controller;

import com.example.quan_lyban_hang_angular.dto.respone.ResponeMessage;
import com.example.quan_lyban_hang_angular.model.Product;
import com.example.quan_lyban_hang_angular.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        if (productService.existsByName(product.getName())) {
            return new ResponseEntity<>(new ResponeMessage("name_product_exist"), HttpStatus.OK);
        }
        if (product.getAvatarProduct()==null) {
            return new ResponseEntity<>(new ResponeMessage("no_avatar_product"), HttpStatus.OK);
        }
        productService.save(product);
        return new ResponseEntity<>(new ResponeMessage("yes"), HttpStatus.OK);
    }
}
