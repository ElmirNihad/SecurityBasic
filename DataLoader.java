package org.example.securityb;

import org.example.securityb.Model.User;
import org.example.securityb.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminUsername = "Elmir";
            String adminPassword = "elmir123";

            if (userRepository.findByUsername(adminUsername).isEmpty()) {
                User admin = new User();
                admin.setUsername(adminUsername);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("Admin istifadəçisi yaradıldı: " + adminUsername + " / " + adminPassword);
            } else {
                System.out.println("Admin istifadəçisi artıq mövcuddur.");
            }
        };
    }
}
