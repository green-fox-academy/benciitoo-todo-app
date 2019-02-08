import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //String proba = args[0];
        //String proba2 = args[1];

        //System.out.println(proba + " xxx " + proba2);

        if (args.length == 0) {
            System.out.println("Command Line Todo application");
            System.out.println("=============================");
            System.out.println("\nCommand line arguments:");
            System.out.println("-l   Lists all the tasks");
            System.out.println("-a   Adds a new task");
            System.out.println("-r   Removes an task");
            System.out.println("-c   Completes an task");
        } else if (args[0].equals("-l")) {
            Path filepath = Paths.get("todolist.txt");
            try {
                List<String> fileContentArray = Files.readAllLines(filepath);
                for (String line :
                        fileContentArray) {
                    System.out.println(line);
                }
            } catch (IOException ex){
                System.out.println("Cannot read from file!");
            }

        }








    }



}