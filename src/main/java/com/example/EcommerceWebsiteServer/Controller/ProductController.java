package com.example.EcommerceWebsiteServer.Controller;

import com.example.EcommerceWebsiteServer.Entity.Product;
import com.example.EcommerceWebsiteServer.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        boolean isadd = productService.add(product);
        if (isadd) {
            return ResponseEntity.ok("Thêm sản phẩm thành công!");
        }
        return ResponseEntity.badRequest().body("Thêm sản phẩm thất bại!");
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        if (product != null) {
            return product;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        boolean check= productService.deleteProduct(id);
        if(check){
            return ResponseEntity.ok("Xóa sản phẩm không thành công");
        }
        return ResponseEntity.ok("Không thể xóa sản phẩm");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product){
        boolean check=productService.updateProduct(id,product);
        if(check){
            return ResponseEntity.ok("Sửa thông tin sản phẩm thành công !");
        }
        return ResponseEntity.ok("Chỉnh sửa thông tin sản phẩm thất bại !");
    }



}
