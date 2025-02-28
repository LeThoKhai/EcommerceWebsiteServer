package com.example.EcommerceWebsiteServer.Controller;

import com.example.EcommerceWebsiteServer.Entity.Category;
import com.example.EcommerceWebsiteServer.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getall(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return categoryService.getById(id);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Category category){
        categoryService.add(category);
        return ResponseEntity.ok(category);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Category category){
        categoryService.update(id,category);
        return ResponseEntity.ok("Update thành công");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.ok("Xoá category có id = " + id + " thành công");
    }

}
