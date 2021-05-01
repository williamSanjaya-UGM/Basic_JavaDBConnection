package mongodb;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;

public class MainAggregate {
    public static void main(String[] args) {
        ConnectionString connString=new ConnectionString("mongodb://localhost:27017/javaTest");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient= MongoClients.create(settings);

        MongoDatabase database = mongoClient.getDatabase("javaTest");
        MongoCollection<Document> collection = database.getCollection("test");

        System.out.println("Database Connected");

        collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("age", 25)),
                        Aggregates.group("$address", Accumulators.sum("count", 1)
                        ))
        ).forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("Collection aggregated.");
    }
}
