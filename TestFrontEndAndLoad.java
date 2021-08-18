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
import javafx.application.Application;

/**
* This class contains all the test methods to test functionality of front end and load, taking into
* consideration the static loader of the front end.
* 
* @author Lucy Kuo
*/
class TestFrontEndAndLoad {

  /**
   * Test the functionality for loading data
   * 
   */
  @Test
  void dataLoadedTest() {

    Loader loader = new Loader();
    if (loader.backEnd == null) {
      fail("data not found");
    }
  }
  
  /**
   * Tests that getSinger is functioning correctly in front end.
   * 
   */
  @Test
  void testGetSinger() {
    FrontEnd frontEnd = new FrontEnd();
    
    String expected = "The Beatles\n" + 
        "A Day in the Life\n" + 
        "Strawberry Fields Forever\n" + 
        "Penny Lane";
    
    if(!frontEnd.getSinger("The Beatles").equals(expected)) {
      fail("getSinger() failed"); 
    }
  }
  
  /**
   * Tests that addSinger is functioning correctly in front end.
   * 
   */
  @Test
  void testAddSinger() {
    FrontEnd frontEnd = new FrontEnd();
    frontEnd.addSinger("example", "song1", "song2", "song3");
    
    String expected = "1. The Beatles\n" + 
        "2. The Rolling Stones\n" + 
        "3. Elton John\n" + 
        "4. Mariah Carey\n" + 
        "5. Madonna\n" + 
        "6. The Beatles\n" + 
        "7. The Rolling Stones\n" + 
        "8. Elton John\n" + 
        "9. Mariah Carey\n" + 
        "10. Madonna\n" + 
        "11. example\n" + 
        "";
    
    if(!frontEnd.displayAllSingers().equals(expected)) {
      fail("addSinger() failed; not in database or displayed when called"); 
    }
  }
  
  /**
   * Tests that removeSinger is functioning correctly in front end.
   * 
   */
  @Test
  void testRemoveSinger() {
    FrontEnd frontEnd = new FrontEnd();
    
    frontEnd.removeSinger("Elton John");
    
    String expected = "1. The Beatles\n" + 
        "2. The Rolling Stones\n" + 
        "3. Elton John\n" + 
        "4. Mariah Carey\n" + 
        "5. Madonna\n" + 
        "6. The Beatles\n" + 
        "7. The Rolling Stones\n" + 
        "8. Elton John\n" + 
        "9. Mariah Carey\n" + 
        "10. Madonna\n" + 
        "";
    
    if(!frontEnd.displayAllSingers().equals(expected)) {
      fail("removeSinger() failed; singer still in database and displayed when called"); 
    }
  }

  /**
   * Tests that display all singers is functioning correctly in front end.
   * 
   */
  @Test
  void testDisplayAllSingers() {
    FrontEnd frontEnd = new FrontEnd();
    
    String expected = "1. The Beatles\n" + 
        "2. The Rolling Stones\n" + 
        "3. Elton John\n" + 
        "4. Mariah Carey\n" + 
        "5. Madonna\n" + 
        "";
    
    if(!frontEnd.displayAllSingers().equals(expected)) {
      fail("displayAllSingers() failed"); 
    }
  }
}
