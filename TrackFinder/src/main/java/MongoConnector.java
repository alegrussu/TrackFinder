import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnector {


    private static final String conn = "mongodb://localhost:27017";
    private static final String db_name = "TrackSeeker";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        try {
            mongoClient = MongoClients.create(conn);
            database = mongoClient.getDatabase(db_name);
            System.out.println("Connessun to MongoDB: Successfull");
        } catch (Exception e) {
            System.err.println("An error has occured while connecting to MongoDB: " + e.getMessage());
        }
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Connection to MongoDB closed.");
        }
    }
}
