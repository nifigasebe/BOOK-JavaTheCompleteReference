import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Chizhov-AS on 08.04.2015.
 */
public class DirList {
    public static void main(String[] args) {
        String dirName = "C:\\-MyAll-\\-Soft-\\SQLiteStudio\\";

        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirName),("{*}.{dll}"))){
            System.out.println("Directory of " + dirName);

            for(Path entry : dirstrm){
                BasicFileAttributes attributes = Files.readAttributes(entry,BasicFileAttributes.class);

                if (attributes.isDirectory()){
                    System.out.print("DIR>> ");
                } else {
                    System.out.print("      ");
                }

                System.out.println(entry.getFileName());
            }
        } catch (InvalidPathException ex){
            System.out.println("InvalidPathException" + ex);
        } catch (NotDirectoryException ex){
            System.out.println("NotDirectoryException" +ex);
        } catch (IOException ex) {
            System.out.println("IOException" + ex);
        }
    }
}
