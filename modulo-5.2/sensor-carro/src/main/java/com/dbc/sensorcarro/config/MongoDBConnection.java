package com.dbc.sensorcarro.config;

import com.dbc.sensorcarro.exception.BusinessRuleException;
import com.mongodb.MongoClientException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String URI = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&directConnection=true&ssl=false";
    private MongoClient client;

    public MongoDatabase connection() throws BusinessRuleException {
        MongoDatabase connection;
        try {
            client = MongoClients.create(URI);
            connection = client.getDatabase("carroIOT");
        } catch (MongoClientException e) {
            throw new BusinessRuleException(e.getMessage());
        }
        return connection;
    }

    public void close() {
        client.close();
    }

}
