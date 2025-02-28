package com.example.EcommerceWebsiteServer.Service;

import com.example.EcommerceWebsiteServer.Entity.Role;
import com.example.EcommerceWebsiteServer.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role addrole(Role role){
        Role roles = roleRepository.save(role);
        return roles;
    }

    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    public boolean delete(Long id){
        if(roleRepository.existsById(id)){
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
//    public Role findByRolename(String name){
//        return roleRepository.findByRolename(name);
//    }

}
