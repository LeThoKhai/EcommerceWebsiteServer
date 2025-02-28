package com.example.EcommerceWebsiteServer.Repository;

import com.example.EcommerceWebsiteServer.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    Category findBycategoryName(String name);
}