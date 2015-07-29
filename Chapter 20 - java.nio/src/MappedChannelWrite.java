import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

/**
 * Created by Chizhov-AS on 07.04.2015.
 */
public class MappedChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel)Files.newByteChannel(Paths.get("test4.txt"),StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)){
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE,0,26);

            for(int i=0;i<26;i++){
                mBuf.put((byte)('A' + i));
            }
        }catch (InvalidPathException e){
            System.out.println("Path error" + e);
        }catch (IOException e){
            System.out.println("IOError" + e);
        }
    }
}
