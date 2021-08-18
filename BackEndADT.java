// --== CS400 File Header Information ==--
// Name: <Tzu Chi Huang (Aris)>
// Email: <thuang245@wisc.edu>
// Team: <GD>
// Role: <Back End Developer 1>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>

/**
 * This is the interface for the Front End developers to know the functionalities of the HashTable
 * that we are using in this application. This functionalities indicate how users can navigate and
 * interact with the application.
 * 
 * @author Aris Huang
 *
 */
public interface BackEndADT {

  /**
   * This method resembles the put(Key k, Value v) in HashTable.
   * 
   * @param singerName the singer name
   * @param songs      the Song object containing singer's name and his or her top 3 songs
   * @return true if singer and his or her top 3 songs are added successfully to the HashTable,
   *         otherwise false.
   */
  public boolean addSinger(String singerName, Song songs);

  /**
   * This method resembles the remove(Key k) in HashTable. However, this will return a boolean value
   * instead of returning a Song object that is paired with the key in this case the String of
   * singerName.
   *
   * @param singerName the singer name
   * @return true if successfully removed a key-value pair (singer-song) from the hashtable,
   *         otherwise false.
   */
  public boolean removeSinger(String singerName);

  /**
   * This method resembles the get(Key k) in HashTable. This method simply behaves like a search engine.
   * 
   * @param singerName the singer name
   * @return the Song object containing singer's name and his or her top 3 songs
   */
  public Song getSinger(String singerName);

  /**
   * This method resembles the containsKey(Key k) in HashTable to check if the singer already exists
   * in the database.
   * 
   * @param singerName the singer name
   * @return true if singer is in the database, otherwise false.
   */
  public boolean containSinger(String singerName);
}
