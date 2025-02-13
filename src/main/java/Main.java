public class Main {
  public static void main(String[] args) {
    SpotifyDAO spotifyDAO = new SpotifyDAO();
    SpotifyHistory history = spotifyDAO.getLastPlayedSong();

    if(history != null){
      System.out.println("Last song:"+ history);
    } else {
      System.out.println("No song found");
    }
    spotifyDAO.close();
  }
}



