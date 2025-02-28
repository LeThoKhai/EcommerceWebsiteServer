package com.example.EcommerceWebsiteServer.Service;

import com.example.EcommerceWebsiteServer.Entity.Product;
import com.example.EcommerceWebsiteServer.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Product getByName(String name){
        return productRepository.getByproductName(name);
    }
    public Boolean add(Product product) {
        return productRepository.save(product) != null;
    }
    public Boolean updateProduct(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            Product existingProduct = productRepository.findById(id).get();
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setSoldQuantity(updatedProduct.getSoldQuantity());
            existingProduct.setProductImage(updatedProduct.getProductImage());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDiscount(updatedProduct.getDiscount());
            existingProduct.setCheckDiscount(updatedProduct.getCheckDiscount());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setDescription(updatedProduct.getDescription());
            productRepository.save(existingProduct);
            return true;
        }
        return false;
    }
    public Product getById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public Boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
