package com.example.EcommerceWebsiteServer.Controller;

import com.example.EcommerceWebsiteServer.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity) {
        return cartService.addToCart(userId, productId, quantity);
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestParam Long orderId) {
        return cartService.checkout(orderId);
    }
}