import org.bson.Document

public class SpotifyHistory{
  private String trackName;
  private List<String> artist;
  private String album;
  private long timestamp;

  public SpotifyHistory(String trackName, String artist, String album, long timestamp) {
     this.trackName = trackName;
     this.artist = artist;
     this.album = album;
     this.timestamp = timestamp;
  }

  public static SpotifyHisory fromDocument(Document doc) {
    return new SpotifyHistory(
      doc.getString("master_metadata_track_name"),
      doc.getString("master_metadata_album_artist_name"),
      doc.getString("master_metadata_album_album_name"),
      doc.getLong("ts"),
        );
  }
  
  public double convertToSeconds(long timestamp){
    double convertedTimestamp = timestamp / 1000;
    return convertedTimestamp;
  }

  
  @Override
  public String toString() {
    String s = "\n| Song: "+trackName + "\n| Artist: "+artist + "\n| Album: "+album + "| Timestamp: " +timestamp;
  }


}









