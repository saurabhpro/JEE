import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Saurabh on 3/29/2016.
 */
public class App {
    public static void main(String[] args) {
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(200).build();
//        MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoClient client = new MongoClient(new ServerAddress(),options);

        MongoDatabase db = client.getDatabase("test").withReadPreference(ReadPreference.secondary());//are immutable

        MongoCollection collection = db.getCollection("test");
    }
}
