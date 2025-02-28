package com.example.EcommerceWebsiteServer.Service;

import com.example.EcommerceWebsiteServer.Entity.Category;
import com.example.EcommerceWebsiteServer.Repository.CategoryRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public Category add(Category category){
        Category ct= categoryRepository.save(category);
        return ct;
    }
    public Category getById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
    public Boolean update(Long id,Category category){
        if(categoryRepository.existsById(id)){
            Category ct= getById(id);
            ct.setCategoryName(category.getCategoryName());
            categoryRepository.save(ct);
            return true;
        }
        return false;
    }
    public Boolean delete(Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
