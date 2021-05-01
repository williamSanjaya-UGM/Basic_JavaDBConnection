package mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MainInsertDocument {
    public static void main(String[] args) {
        ConnectionString connString=new ConnectionString("mongodb://localhost:27017/javaTest");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient= MongoClients.create(settings);

        MongoDatabase database = mongoClient.getDatabase("javaTest");
        MongoCollection collection= database.getCollection("test");

        Document mDocument = new Document("name","Sanjay")
                .append("sex","male")
                .append("age",25)
                .append("address","alamat Sanjay");

        collection.insertOne(mDocument);
    }
}
