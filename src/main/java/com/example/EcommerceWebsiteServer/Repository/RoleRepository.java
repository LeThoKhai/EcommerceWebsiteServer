package com.example.EcommerceWebsiteServer.Repository;

import com.example.EcommerceWebsiteServer.Entity.Role;
import com.example.EcommerceWebsiteServer.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByroleName(String username);
}
