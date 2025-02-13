import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

public class SpotifyDAO {
  private final MongoCollection<Document> collection;

  public SpotifyDAO() {
    MongoDatabase database = MongoDBConnector.getDataBase();
    this.collection = database.getCollection("spotify_history");
  }
}

public SpotifyHistory getLastPlayedSong() {
  Document lastPlayed = collection.find().sort(Sorts.descending("ts")).first();
  return lastPlayed != null ? SpotifyHistory.fromDocument(lastPlayed) : null;
}

public void close() {
  MongoDBConnector.closeConnection();
}




























