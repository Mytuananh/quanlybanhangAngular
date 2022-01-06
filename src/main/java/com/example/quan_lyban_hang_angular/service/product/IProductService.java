package com.example.quan_lyban_hang_angular.service.product;

import com.example.quan_lyban_hang_angular.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    boolean existsByName(String name);
    List<Product> findAll();
    Page<Product> findAll(Pageable pageable);
    void deleteById(Long id);
    Product save(Product product);
    Optional<Product> findById(Long id);

}
