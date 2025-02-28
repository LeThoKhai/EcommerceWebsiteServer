package com.example.EcommerceWebsiteServer.Repository;

import com.example.EcommerceWebsiteServer.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
