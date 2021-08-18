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
import java.io.File;
import java.util.Scanner;

/**
* This class contains all the test methods to test correct format of data files.
* 
* @author Lucy Kuo
*/
class TestData {

  /**
   * Tests that data is parsed correctly by creating arrays of the data by checking that all 
   * elements are strings.
   * 
   */
  @Test
  void test() {
    File file = new File("Data.txt");
    Scanner scan = null;
    
    try {
      scan = new Scanner(file);
    }
    catch(Exception e) {
      System.out.println("scanner could not be formed");
    }
    
    String current = null;
    String[] elements = new String[4];
    while(scan.hasNextLine()) {
      current = scan.nextLine();
      elements = current.split(",");
      
      for(int i = 0; i < elements.length; i++) {
        if(!(elements[i] instanceof String)) {
          fail("not a string, incorrect element type");
        }
      }
    }
    
    scan.close();
  }

}
