import java.io.*;
import java.nio.*;
import java.nio.file.*;

/**
 * Created by Chizhov-AS on 07.04.2015.
 */
public class NIOCopy {
    public static void main(String[] args) {

        String out = "C:\\test.txt";
        String in = "\\\\10.10.64.144\\c$\\Temp\\ttt\\";

        try {
            Path target = Paths.get(in);
            Path source = Paths.get(out);

            Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);
        }catch (InvalidPathException e){
            System.out.println("Path Error"+e);
        }catch (IOException e){
            System.out.println("IO ERROR"+e);
        }
    }
}
