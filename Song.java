// --== CS400 File Header Information ==--
// Name: <Tzu Chi Huang (Aris)>
// Email: <thuang245@wisc.edu>
// Team: <GD>
// Role: <Back End Developer 1>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>

/**
 * This is class for creating a Song object containing the singer's name and his or her top 3 songs.
 * It also contains accessor and mutator methods of the fields in this class.
 * 
 * @author Aris Huang
 *
 */
public class Song {
  private String singerName;
  private String songOne;
  private String songTwo;
  private String songThree;

  /**
   * The constructor used to create a Song object.
   * 
   * @param singerName the singer's name
   * @param songOne    the 1st ranking song
   * @param songTwo    the 2nd ranking song
   * @param songThree  the 3rd ranking song
   */
  public Song(String singerName, String songOne, String songTwo, String songThree) {
    this.singerName = singerName;
    this.songOne = songOne;
    this.songTwo = songTwo;
    this.songThree = songThree;
  }

  /**
   * The accessor method for getting the name of the singer.
   * 
   * @return singerName
   */
  public String getSingerName() {
    return this.singerName;
  }

  /**
   * The mutator method to set the singer's name.
   * 
   * @param singerName
   */
  public void setSingerName(String singerName) {
    this.singerName = singerName;
  }

  /**
   * The accessor method for the 1st ranking song of the singer.
   * 
   * @return songOne
   */
  public String getFirstSong() {
    return this.songOne;
  }

  /**
   * The mutator method to set the first ranking song.
   * 
   * @param firstSong
   */
  public void setFirstSong(String firstSong) {
    this.songOne = firstSong;
  }

  /**
   * The accessor method for the 2nd ranking song of the singer.
   * 
   * @return songTwo
   */
  public String getSecondSong() {
    return this.songTwo;
  }

  /**
   * The mutator method to set the second ranking song.
   * 
   * @param secondSong the second ranking song
   */
  public void setSecondSong(String secondSong) {
    this.songTwo = secondSong;
  }

  /**
   * The accessor method for the 3rd ranking song of the singer.
   * 
   * @return songThree
   */
  public String getThirdSong() {
    return this.songThree;
  }

  /**
   * The mutator method to set the third ranking song of the singer.
   * 
   * @param thirdSong
   */
  public void setThirdSong(String thirdSong) {
    this.songThree = thirdSong;
  }
}
