package com.azship.api.infra.config.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class MongoParameters {
    
    @Value("${MONGODB_HOST}")
    private String mongoHost;

    @Value("${MONGODB_PORT}")
    private int mongoPort;

    @Value("${MONGODB_DATABASE}")
    private String mongoDB;

    @Value("${MONGODB_USERNAME}")
    private String mongoUsername;

    @Value("${MONGODB_PASSWORD}")
    private String mongoPassword;
}
