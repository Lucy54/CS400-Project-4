// --== CS400 File Header Information ==--
// Name: <Shin-Tsz (Lucy) Kuo>
// Email: <skuo8@wisc.edu>
// Team: <your team name: GD>
// Role: <Test Engineer 1>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
* This class contains all the test methods to test functionality of hash table map and ADT.
* 
* @author Lucy Kuo
*/
class TestBackEnd {

  /**
  * Tests put method and ensures that hash table map adds the correct element by re-accessing.
  * 
  */
  @Test
  void testAddSinger() {
    BackEnd testBackEnd = new BackEnd();
    Song whitney = new Song("Whitney Houston", "I Wanna Dance with Somebody", "Higher Love", 
        "I Will Always Love You");
    
    testBackEnd.addSinger("Whitney Houston", whitney);
    if (!testBackEnd.getSinger("Whitney Houston").equals(whitney)) {
      fail("false add singer");
    }
  }
  
  /**
  * Tests that remove method correctly removes singer.
  * 
  */
  @Test
  void testRemoveSinger() {
    BackEnd testBackEnd = new BackEnd();
    Song michael = new Song("Michael Jackson", "Don't Matter To Me", "Billie Jean", "P.Y.T.");
    testBackEnd.addSinger("Michael Jackson", michael);
    
    if (!testBackEnd.removeSinger("Michael Jackson")) {
      fail("false remove singer");
    }
  }
  
  /**
  * Tests get singer method to ensure correct song object returned given singer name.
  * 
  */
  @Test
  void testGetSinger() {
    BackEnd testBackEnd = new BackEnd();
    Song frank = new Song("Frank Sinatra", "Fly Me to the Moon", "My Way", 
        "The Way You Look Tonight");
    testBackEnd.addSinger("Frank Sinatra", frank);
    
    if (!testBackEnd.getSinger("Frank Sinatra").equals(frank)) {
      fail("false get singer");
    }
  }
  
  /**
  * Tests Contain Singer method to check that backend correctly calls contain.
  * 
  */
  @Test
  void testContainSinger() {
    BackEnd testBackEnd = new BackEnd();
    Song frank = new Song("Frank Sinatra", "Fly Me to the Moon", "My Way", 
        "The Way You Look Tonight");
    testBackEnd.addSinger("Frank Sinatra", frank);
    
    if (!testBackEnd.getSinger("Frank Sinatra").equals(frank)) {
      fail("false contain Singer");
    }
  }

}
