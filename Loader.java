import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader {

    /**
     * BackEnd object to load.
     */
    public BackEnd backEnd;

    /**
     * No arguments constructor for the Loader class.
     * Calls load method to load data from CSV file into a BackEnd object.
     */
    public Loader() {
        this.backEnd = new BackEnd();
        load();
    }

    public void load() {
        File file = null;
        Scanner scnr = null;
        try {
            file = new File("Data.txt");
            scnr = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scnr.hasNextLine()) {

            String[] arr = scnr.nextLine().split(",");

            System.out.println(arr[0]);

            for (int i = 0; i < 4; i++) {
                arr[i] = arr[i].trim();
            }

            backEnd.addSinger(arr[0], new Song(arr[0], arr[1], arr[2], arr[3]));
        }

        scnr.close();
    }

    public static void main(String[] args) {
        Loader loader = new Loader();
    }
}
