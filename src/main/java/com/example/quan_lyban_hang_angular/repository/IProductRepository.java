package com.example.quan_lyban_hang_angular.repository;

import com.example.quan_lyban_hang_angular.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);

}
