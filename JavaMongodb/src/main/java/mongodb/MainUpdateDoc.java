package mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MainUpdateDoc {
    public static void main(String[] args) {
        ConnectionString connString=new ConnectionString("mongodb://localhost:27017/javaTest");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient= MongoClients.create(settings);

        MongoDatabase database = mongoClient.getDatabase("javaTest");
        MongoCollection collection= database.getCollection("test");

        System.out.println("Database connected");

        Document found= (Document) collection.find(new Document("name","William")).first();

        if(found!=null) {
            System.out.println("User found "+found);
            Bson updateVal = new Document("age",35);
            Bson updateOperation = new Document("$set",updateVal);
            collection.updateOne(found,updateOperation);
            System.out.println("User Updated");
        }
    }
}
