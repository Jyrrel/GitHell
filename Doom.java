import java.io.*;
import java.util.Date;

public class Doom {

    public static void main(String[] args) {
        try {
            File folder = new File("gen");
            if (!folder.exists()) {
                folder.mkdir();
            }
      
            for (int i = 1; i <= 100; i++) {
                File file = new File("gen/abyss" + i + ".txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("Generated at: " + new Date().toString() + " - HAHAHAHA! Welcome to the abyss " + i);
                    System.out.println("The abyss " + i + " has been forged in the darkest depths: " + file.getAbsolutePath());
                }
                logToFile("git-commit-log.txt", "Created abyss" + i + ".txt at: " + new Date().toString());
            }

            File readmeFile = new File("gen/README.yml");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(readmeFile))) {
                writer.write("HAHAHAHAHHA - The abyss grows larger, every minute it consumes more...");
            }

        } catch (Exception e) {
            System.err.println("An error occurred... but you can't escape GitHell: " + e.getMessage());
        }
    }

    private static void logToFile(String filename, String message) {
        try (FileWriter logWriter = new FileWriter(filename, true);
             BufferedWriter logBuffer = new BufferedWriter(logWriter)) {
            logBuffer.write(message);
            logBuffer.newLine();
        } catch (IOException e) {
            System.err.println("Error logging commit: " + e.getMessage());
        }
    }
}
