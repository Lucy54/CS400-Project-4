// --== CS400 File Header Information ==--
// Name: <Shin-Tsz (Lucy) Kuo>
// Email: <skuo8@wisc.edu>
// Team: <your team name: GD>
// Role: <Test Engineer 1>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

/**
* This class contains all the test methods to test functionality of hash table map.
* 
* @author Lucy Kuo
*/
class TestHashTable {

  /**
   * Tests constructor and ensures that pair creation and key accessor internal method works.
   */
  @Test
  void testConstructor() {
    HashTableMap<String, Song> testMap = new HashTableMap<String, Song>(10);
    HashTableMap<String, Song>.Pair testPair = testMap.new Pair("sample", new Song("song1", "song2",
        "song3", "song4"));
    
    if(!testPair.getKey().equals("sample")) {
      fail("invalid constructor");
    }
  }
  
  /**
   * Tests put method and ensures that hash table map adds the correct element by re-accessing.
   */
  @Test
  void testPut() {
    HashTableMap<String, Song> testMap = new HashTableMap<String, Song>(28);
    Song testSong = new Song("song1", "song2", "song3", "song4");
    testMap.put("sample", testSong);
    if (!testMap.get("sample").equals(testSong)) {
      fail("get method failed");
    }
  }
  
  /**
   * Tests that remove method returns correct removed key for valid and invalid keys.
   */
  @Test
  void testRemove() {
    HashTableMap<String, Song> testMap = new HashTableMap<String, Song>(14);
    Song testSong = new Song("song1", "song2", "song3", "song4");
    testMap.put("sample", testSong);
    
    //test 1: invalid
    try {
      testMap.remove("invalid");
    } catch (NoSuchElementException e) {
      System.out.println("caught");
    }
    finally {
      System.out.println("exception successfuly caught");
    }
    
    //test 2: valid remove
    if (!testMap.remove("sample").equals(testSong)) {
      fail("valid remove failed");
    }
  }
  
  /**
   * Tests clear method and ensures that size is 0 after clearing.
   */
  @Test
  void testClear() { 
    HashTableMap<String, Song> testMap = new HashTableMap<String, Song>(23);
    HashTableMap<String, Song>.Pair testPair = testMap.new Pair("sample", new Song("song1", "song2"
        , "song3", "song4"));
    testMap.clear();
    
    if (testMap.size() != 0) {
      fail("clear failed");
    }
  }
  
  /**
   * Tests containsKey method to check that map contains certain key.
   */
  @Test
  void testContainsKey() { 
    HashTableMap<String, Song> testMap = new HashTableMap<String, Song>(27);
    Song testSong = new Song("song1", "song2", "song3", "song4");
    testMap.put("sample", testSong);
    
    if (!testMap.containsKey("sample")) {
      fail("containsKey failed");
    }
  }

}
