package com.example.quan_lyban_hang_angular.service.role;

import com.example.quan_lyban_hang_angular.model.Role;
import com.example.quan_lyban_hang_angular.model.RoleName;
import com.example.quan_lyban_hang_angular.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
