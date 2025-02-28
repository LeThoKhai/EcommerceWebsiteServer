package com.example.EcommerceWebsiteServer.Repository;

import com.example.EcommerceWebsiteServer.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product getByproductName(String name);
}
