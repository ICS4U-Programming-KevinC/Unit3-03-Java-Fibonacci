import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Does the fibonacci thing.
 *
 * @author Kevin Csiffary
 * @version 1.0
 * @since 2024-05-01
 */

// Fibonacci class
public final class Fibonacci {

  /** Private constructor to prevent instantiation. */
  private Fibonacci() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    try {
      // Setup scanner on file.
      File file = new File("input.txt");
      Scanner sc = new Scanner(file);
      // Setup writer for output file.
      FileWriter writer = new FileWriter("output.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      while (sc.hasNextLine()) {
        // Read the line from file.
        String line = sc.nextLine();

        // Check if line is valid input.
        try {
          int intLine = Integer.parseInt(line);
          // Call method and write to file.
          bufferedWriter.write(Integer.toString(recFib(intLine)));
        } catch (Exception e) {
          // Catch non number error.
          bufferedWriter.write("Please input a number!");
        }
        // Writes a new line.
        bufferedWriter.newLine();
      }

      // Close all writers and scanner.
      bufferedWriter.close();
      writer.close();
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Calculates the value of the fibonacci sequence at a specific position.
   *
   * @param num
   * @return An int of the fibonacci sequence at that pos.
   */
  public static Integer recFib(final Integer num) {
    // Check for the first two base cases of 0 and 1, then return that value.
    if (num == 1) {
      return 1;
    } else if (num == 0) {
      return 0;
    } else {
      // Calculate the previous two terms then add them.
      return recFib(num - 1) + recFib(num - 2);
    }
  }
}
