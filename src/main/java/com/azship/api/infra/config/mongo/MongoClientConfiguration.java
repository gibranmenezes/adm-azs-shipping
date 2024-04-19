package com.azship.api.infra.config.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "java.com.azship.api.infra.repository")
public class MongoClientConfiguration extends AbstractMongoClientConfiguration {
    
    private final MongoParameters mongoParameters;

    @Autowired
    public MongoClientConfiguration(MongoParameters mongoParameters) {
        this.mongoParameters = mongoParameters;
    }

    @Override
    protected String getDatabaseName() {
        return mongoParameters.getMongoDB();
    }

    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString(String.format(
            "mongodb://%s:%s@%s:%s/%s?authSource=admin",
            mongoParameters.getMongoUsername(),
            mongoParameters.getMongoPassword(),
            mongoParameters.getMongoHost(),
            mongoParameters.getMongoPort(),
            getDatabaseName()
        ));
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }
}
