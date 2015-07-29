import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Chizhov-AS on 08.04.2015.
 */
public class DirList2 {
    public static void main(String[] args) {
        String dirName = "C:\\-MyAll-\\-Soft-\\SQLiteStudio\\";

        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>(){
            public boolean accept(Path filename) throws IOException{
                if(Files.isDirectory(filename)){
                    return true;
                }
                return false;
            }
        };

        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirName), how)){
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
