package com.example.quan_lyban_hang_angular.controller;

import com.example.quan_lyban_hang_angular.dto.respone.ResponeMessage;
import com.example.quan_lyban_hang_angular.model.Product;
import com.example.quan_lyban_hang_angular.model.User;
import com.example.quan_lyban_hang_angular.security.userprincal.UserDetailServices;
import com.example.quan_lyban_hang_angular.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private UserDetailServices userDetailServices;
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        User user = userDetailServices.getCurrentUser();
        if (user.getUsername().equals("Anonymous")) {
            return new ResponseEntity<>(new ResponeMessage("Please login!"), HttpStatus.OK);
        }
        if (productService.existsByName(product.getName())) {
            return new ResponseEntity<>(new ResponeMessage("name_product_exist"), HttpStatus.OK);
        }
        if (product.getAvatarProduct()==null) {
            return new ResponseEntity<>(new ResponeMessage("no_avatar_product"), HttpStatus.OK);
        }
        productService.save(product);
        return new ResponseEntity<>(new ResponeMessage("yes"), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<?> showListProduct() {
        List<Product> productList = productService.findAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
