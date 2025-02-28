package com.example.EcommerceWebsiteServer;

import com.example.EcommerceWebsiteServer.Entity.Role;
import com.example.EcommerceWebsiteServer.Entity.User;
import com.example.EcommerceWebsiteServer.Repository.RoleRepository;
import com.example.EcommerceWebsiteServer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class EcommerceWebsiteServerApplication  implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(EcommerceWebsiteServerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		Role roleadmin= roleRepository.findByroleName("ROLE_ADMIN");
//		User admin = new User();
//		admin.setUsername("admin");
//		admin.setPassword(new BCryptPasswordEncoder().encode("admin123")); // Mã hóa mật khẩu
//		admin.setFullName("Admin User");
//		admin.setGmail("admin@example.com");
//		admin.setAddress("Admin Address");
//		admin.setBirthday(new Date());
//		admin.setRole(roleadmin);
//		admin.setAvatarImg("default.png");
//		userRepository.save(admin);
//		System.out.println("Admin user created successfully!");
	}
}
