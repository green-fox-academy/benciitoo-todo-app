import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        if (args.length == 0) {
            printUsage();
        } else if (args[0].equals("-l")) {
            listElements();
        } else if (args[0].equals("-a")) {
            if (args.length < 2) {
                System.out.println("Unable to add: no task provided");
            } else {
                addTask(args[1], args); }
        } else if (args[0].equals("-r")) {
            removeTask(args[1]);
        }
    }


    public static void printUsage(){
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println("\nCommand line arguments:");
        System.out.println("-l   Lists all the tasks");
        System.out.println("-a   Adds a new task");
        System.out.println("-r   Removes a task");
        System.out.println("-c   Completes a task");
    }


    public static void addTask(String taskToBeAdd, String[] argumentList){
            List<String> listToBeExpanded = readFileIntoList();
            listToBeExpanded.add(taskToBeAdd);
            writeFile(listToBeExpanded);
    }


    public static void removeTask(String taskToBeRemoved){
        List<String> listToBeShrinked = readFileIntoList();
        int castedint = Integer.parseInt(taskToBeRemoved);
        listToBeShrinked.remove(castedint - 1);
        writeFile(listToBeShrinked);
    }


    public static void listElements(){
        if (readFileIntoList().size() == 0){
            System.out.println("No todos for today! :)");
        } else {
            for (int i = 0; i < readFileIntoList().size(); i++) {
                System.out.println((i + 1) + " - " + readFileIntoList().get(i));
            }
        }
    }


    public static void writeFile(List<String> listToWriteToFile){
        try{
            Files.write(FileHandler.giveFilePath(), listToWriteToFile);
        } catch (IOException ex){
            System.out.println("Cannot write to file.");
        }
    }


    public static List<String> readFileIntoList() {
        List<String> fileContentArray = new ArrayList<>();
     try {
         fileContentArray = Files.readAllLines(FileHandler.giveFilePath());
      } catch (IOException ex) {
          System.out.println("Cannot read from file!");
      }
       return fileContentArray;
    }



}