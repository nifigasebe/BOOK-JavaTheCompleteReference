import java.io.IOException;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

/**
 * Created by Chizhov-AS on 09.04.2015.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {

    public FileVisitResult visitFile(Path path,BasicFileAttributes attributes) throws IOException{
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

class DirTreeList {
    public static void main(String[] args) {
        String dirName = "C:\\-MyAll-";
        System.out.println("Directiry >> " + dirName );
        try {
            Files.walkFileTree(Paths.get(dirName), new MyFileVisitor());
        } catch (IOException ex){
            System.out.println("IOError" + ex);
        }
    }
}
