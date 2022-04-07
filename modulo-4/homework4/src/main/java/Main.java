import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc_vakinha");

        MongoCollection<Document> users = mongoDatabase.getCollection("users");
        users.deleteMany(new Document());
        MongoCollection<Document> vakinhas = mongoDatabase.getCollection("vakinhas");
        vakinhas.deleteMany(new Document());

        Document user = new Document("nome", "nicolas")
                .append("email", "nicolas@gmail.com")
                .append("document", "12345678900")
                .append("password", "1234")
                .append("vakinhas", Arrays.asList(new Document("id", 1)));

        System.out.println("Document antes de inserir:");
        System.out.println(user);
        users.insertOne(user);
        Document doc = users.find(new Document("nome", "nicolas")).first();
        System.out.println("find por nome");
        System.out.println(doc);
        doc = users.find(new Document("vakinhas.id", 1)).first();
        System.out.println("find por id de vakinha");
        System.out.println(doc);


        users.updateOne(Filters.eq("nome", "nicolas"), new Document("$set", new Document("email" , "nicolasfiedler@gmail.com")));

        doc = users.find(new Document("nome", "nicolas")).first();
        System.out.println("find por nome depois de update");
        System.out.println(doc);

        users.deleteOne(new Document("nome", "nicolas"));

        doc = users.find(new Document("nome", "nicolas")).first();
        System.out.println("find por nome depois de remover");
        System.out.println(doc);


        Document vakinha = new Document("id", 1)
                .append("titulo", "salve o dog")
                .append("descricao", "doguinhos com fome")
                .append("meta", 10000)
                .append("cofre", 0);

        System.out.println("Vakinha antes de inserir:");
        System.out.println(vakinha);
        users.insertOne(vakinha);
        doc = users.find(new Document("id", 1)).first();
        System.out.println("find por Id");
        System.out.println(doc);

        users.updateOne(Filters.eq("id", 1), new Document("$set", new Document("cofre" , 200)));

        doc = users.find(new Document("id", 1)).first();
        System.out.println("find por Id depois de update");
        System.out.println(doc);

        users.deleteOne(new Document("id", 1));

        doc = users.find(new Document("id", 1)).first();
        System.out.println("find por Id depois de remover");
        System.out.println(doc);

        mongoClient.close();
    }
}
