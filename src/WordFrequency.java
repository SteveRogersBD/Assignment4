import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author Aniruddha Biswas Atanu
 * A class to count the frequency of words in a text file.
 */
public class WordFrequency {

    /**
     * Reads a text file and counts the frequency of each word.
     * Prints the word frequency in alphabetical order.
     *
     * @param args Command-line arguments (not used).
     * @throws FileNotFoundException If the input file is not found.
     */
    public static void main(String[] args) throws IOException {
        // Input file name
        String fileName = "wordFreq.txt";
        // Create a File object
        File wordFile = new File(fileName);
        // Create a scanner to read from the file
        Scanner fileReader = new Scanner(wordFile);
        // Create a TreeMap to store word frequencies
        Map<String, Integer> counter = new TreeMap<>();

        // Read each line from the file
        while (fileReader.hasNextLine()) {
            // Read a line
            String line = fileReader.nextLine();
            // Create a scanner to read tokens from the line
            Scanner lineScanner = new Scanner(line);
            // Read each token from the line
            while (lineScanner.hasNext()) {
                // Read a token
                String token = lineScanner.next();
                // Initialize a string to store the word
                String ans = "";
                // Process each character in the token
                for (int i = 0; i < token.length(); i++) {
                    // If the character is not alphabetic
                    if (!Character.isLetter(token.charAt(i))) {
                        // If ans is not empty, break the loop
                        if (!ans.isEmpty()) break;
                            // Otherwise, continue to the next character
                        else continue;
                    }
                    // Append the character to the word
                    ans += token.charAt(i);
                }
                // Convert the word to lowercase
                ans = ans.toLowerCase();
                // Update the word frequency in the counter map
                try {
                    if (!counter.containsKey(ans)) counter.put(ans, 1);
                    else counter.merge(ans, 1, (a, b) -> a + b);
                }catch (NullPointerException e)
                {
                    System.out.println(e.getMessage());
                }catch (ClassCastException e)
                {
                    System.out.println(e.getMessage());
                }catch (IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        }

        // Print the word frequency
        Set<String> keys = counter.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + counter.get(key));
        }
    }
}
