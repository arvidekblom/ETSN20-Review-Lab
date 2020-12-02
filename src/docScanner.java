import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class docScanner {
    /*
    Takes three arguments: operation, search word and file name.
    Searches for the search word in the given file and outputs the lines on which a match was found.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid arguments, exiting program");
            System.exit(0);
        }
        if (args[0].equalsIgnoreCase("search")) {

            try {
                String searchWord = args[1];
                File file = new File(args[2]);
                Scanner scanner = new Scanner(file);

                int lineNum = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lineNum++;
                    if (line.contains(searchWord)) {
                        System.out.println("Match found on line " + lineNum);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Command from argument 1 not recognized, try 'search' instead. Exiting program.");
            System.exit(0);
        }
    }
}
