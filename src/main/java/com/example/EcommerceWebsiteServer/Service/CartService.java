package com.example.EcommerceWebsiteServer.Service;

import com.example.EcommerceWebsiteServer.Entity.*;
import com.example.EcommerceWebsiteServer.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> addToCart(Long userId, Long productId, Integer quantity) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Product> productOptional = productRepository.findById(productId);

        if (userOptional.isEmpty() || productOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy user hoặc product");
        }

        Product product = productOptional.get();
        if (product.getQuantity() < quantity) {
            return ResponseEntity.badRequest().body("Không đủ số lượng");
        }

        Order order = new Order(userOptional.get(), new Date());
        orderRepository.save(order);

        OrderDetail orderDetail = new OrderDetail(null, order, product, quantity, product.getPrice());
        orderDetailRepository.save(orderDetail);

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        return ResponseEntity.ok("Added to cart");
    }

    public ResponseEntity<String> checkout(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Order not found");
        }

        Order order = orderOptional.get();
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrder(order);

        if (orderDetails.isEmpty()) {
            return ResponseEntity.badRequest().body("No items in cart");
        }

        double totalAmount = orderDetails.stream()
                .mapToDouble(od -> od.getQuantity() * od.getPrice())
                .sum();

        return ResponseEntity.ok("Checkout successful. Total amount: " + totalAmount);
    }
}
