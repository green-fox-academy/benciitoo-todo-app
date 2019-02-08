import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    public static Path giveFilePath(){
        Path filePath = Paths.get("todolist.txt");
        return filePath;
    }
}