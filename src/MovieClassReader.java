import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author Aniruddha Biswas Atanu
 * A program to read movie data from files and find common movies between two sets.
 */
public class MovieClassReader {

    /**
     * Reads movie data from files, finds common movies between two sets, and prints them.
     *
     * @param args The command-line arguments (not used).
     * @throws FileNotFoundException If the specified file is not found.
     */
    //can also throw FileNotFoundException. But since it is a subclass of IOException, this method should handle it too.
    public static void main(String[] args) throws IOException {
        // Create File objects for input files
        File file1 = new File("moviesx.txt");
        File file2 = new File("moviesy.txt");

        // Read movie data from files into sets
        Set<Movie> evenSet = readFile(file1);
        Set<Movie> oddSet = readFile(file2);

        // Find common movies between evenSet and oddSet
        Set<Movie> common = new TreeSet<>(evenSet);
        common.retainAll(oddSet);

        // Print common movies
        Iterator<Movie> iter = common.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /**
     * Reads movie data from a file and returns a set of movies.
     *
     * @param file The File object representing the input file.
     * @return A set containing movie objects read from the file.
     * @throws FileNotFoundException If the specified file is not found.
     */
    //can also throw FileNotFoundException. But since it is a subclass of IOException, this method should handle it too.
    public static Set<Movie> readFile(File file) throws IOException {
        // Create an empty set to store movies
        Set<Movie> movieList = new TreeSet<>();

        // Read data from file using Scanner
        Scanner fileScanner = new Scanner(file);
        try{
            while (fileScanner.hasNextLine()) {
                // Read line and split it into year and name
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                int year;
                year = Integer.parseInt(lineScanner.next());

                String name = lineScanner.nextLine().trim();

                // Create Movie object and add it to the set
                Movie movie = new Movie(name, year);
                movieList.add(movie);
                lineScanner.close();

            }
            fileScanner.close();
        }catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
        }


        return movieList;
    }
}
