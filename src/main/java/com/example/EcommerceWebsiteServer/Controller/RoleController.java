package com.example.EcommerceWebsiteServer.Controller;

import com.example.EcommerceWebsiteServer.Entity.Role;
import com.example.EcommerceWebsiteServer.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getRole(){
        return roleService.getAllRole();
    }
    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody Role role) {
        Role addedRole = roleService.addrole(role);
        if (addedRole != null) {
            return ResponseEntity.ok(addedRole); // Trả về role nếu thêm thành công
        }
        return ResponseEntity.badRequest().body("Không thể thêm mới role"); // Trả về lỗi nếu thất bại
    }

}
