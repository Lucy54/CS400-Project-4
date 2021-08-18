import java.util.ArrayList;

// --== CS400 File Header Information ==--
// Name: <Tzu Chi Huang (Aris)>
// Email: <thuang245@wisc.edu>
// Team: <GD>
// Role: <Back End Developer 1>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>

/**
 * This is the BackEnd class containing the HashTable functionalities of this application.
 * 
 * @author Aris Huang
 *
 */
public class BackEnd implements BackEndADT {
  private HashTableMap<String, Song> hashTable;

  public static ArrayList<Song> allSingers = new ArrayList<Song>(); // I added this and below method

  public BackEnd() {
    this.hashTable = new HashTableMap<String, Song>(); // default to have a hashTable of size 10, it
                                                       // will expand by calling the
                                                       // expandHashTable()
  }

  /**
   * This method is used to serves as the put() function in the hash table.
   * 
   * @param singerName the singer name
   * @param songs the Song object containing the top 3 songs of that singer
   * @return true if singer and his or her top 3 songs are added successfully to the HashTable,
   *         otherwise false.
   */
  @Override
  public boolean addSinger(String singerName, Song songs) {
    if (singerName != null && songs != null) { // making sure we have valid inputs
      boolean isAdded = hashTable.put(singerName, songs); // add the singer and songs to the
                                                          // application
      if (isAdded) {
        allSingers.add(songs);
        return true;
      } else {
        System.out
          .println("Failed to add this singer, because the singer is already in the database.");
        return false;
      }
    } else {
      System.out.println("Please enter valid inputs."); // displaying error messages
      return false;
    }
  }

  /**
   * This method resembles the remove(Key k) in HashTable. However, this will return a boolean value
   * instead of returning a Song object that is paired with the key in this case the String of
   * singerName.
   * 
   * @param singerName the singer name
   * @return true if successfully removed a key-value pair (singer-song) from the hashtable,
   *         otherwise false.
   */
  @Override
  public boolean removeSinger(String singerName) {


    if (singerName != null && hashTable.containsKey(singerName)) { // making sure the singer is in
                                                                   // the database
      hashTable.remove(singerName);
      for (int i = 0; i < allSingers.size(); i++) {
        if (allSingers.get(i).getSingerName().toLowerCase().trim()
          .equals(singerName.toLowerCase().trim())) {
          allSingers.remove(i);
        }
      }
      return true;
    }
    return false;
  }

  /**
   * This method resembles the get(Key k) in HashTable. This method simply behaves like a search
   * engine where you type in the key (singer's name), then it will return the corresponding top 3
   * songs from that particular singer.
   * 
   * @param singerName the singer name
   * @return the Song object containing singer's name and his or her top 3 songs
   */
  @Override
  public Song getSinger(String singerName) {
    Song returnedSong = null;
    if (hashTable.containsKey(singerName)) {
      returnedSong = hashTable.get(singerName);
    }
    if (returnedSong != null) { // double check that returnedSong is not null.
      return returnedSong;
    }
    return null;
  }

  /**
   * This method resembles the containsKey(Key k) in HashTable to check if the singer already exists
   * in the database.
   * 
   * @param singerName the singer name
   * @return true if singer is in the database, otherwise false.
   */
  @Override
  public boolean containSinger(String singerName) {
    boolean inTable = false;
    if (singerName != null) {
      inTable = hashTable.containsKey(singerName);
    }
    if (inTable) {
      // System.out.println("The singer is in the database.");
      return true;
    }
    // System.out.println("The singer is NOT in the database.");
    return false;
  }
}
