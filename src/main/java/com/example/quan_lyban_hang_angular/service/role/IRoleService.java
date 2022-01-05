package com.example.quan_lyban_hang_angular.service.role;

import com.example.quan_lyban_hang_angular.model.Role;
import com.example.quan_lyban_hang_angular.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}