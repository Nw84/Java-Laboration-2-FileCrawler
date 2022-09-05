import java.io.File;
import java.util.Scanner;


public class FileCrawler {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter a word to search for");
        String input = inputScanner.nextLine();
        readFiles(System.getProperty("user.dir"), input);
        inputScanner.close();
    }

    private static void readFiles(String Filepath, String input) {
            File currentDirectory = new File(Filepath);
            File[] files = currentDirectory.listFiles();
            Scanner scanner = null; 
            for (File file : files) {
                if(file.isDirectory()) {
                    readFiles(file.toString(), input);
                } else {
                    try {
                    scanner = new Scanner(file);
                    String string = scanner.nextLine();
                    if(string.toLowerCase().contains(input.toLowerCase())) {
                        System.out.println("\nString found in : " + file.getAbsolutePath());
                    }
                } catch(Exception e) {
                    System.err.println("\nFile or directory could not be read at : " + file.getAbsolutePath());
                } 
            } 
        }

    }
}