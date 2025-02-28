package com.example.EcommerceWebsiteServer.Repository;

import com.example.EcommerceWebsiteServer.Entity.Order;
import com.example.EcommerceWebsiteServer.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findByOrder(Order order);
}
