package com.azship.api.utils;

import com.azship.api.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final MongoTemplate mongoTemplate;

    private String generateId(){
        return UUID.randomUUID().toString();
    }

    @Override
    public void run(String... args) throws Exception {
        // Limpar coleções antes de inserir dados
        mongoTemplate.dropCollection(User.class);

        // Inserir novos dados
        List<User> users = createInitialUsers();
        mongoTemplate.insertAll(users);

        System.out.println("Usuários iniciais criados com sucesso.");
    }

    private List<User> createInitialUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String userId = this.generateId();
            User user = User.builder()
                    .id(userId)
                    .build();
            users.add(user);
        }
        return users;
    }
}
