import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

/**
 * Created by Chizhov-AS on 07.04.2015.
 */
public class ExplicitChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel)Files.newByteChannel(Paths.get("test3.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE) ) {
            ByteBuffer mbuf = ByteBuffer.allocate(26);
            for (int i=0; i<26; i++){
                mbuf.put((byte)('A' + i));
            }

            mbuf.rewind();
            fChan.write(mbuf);
        } catch (InvalidPathException e){
            System.out.println("Path error" + e);
        } catch (IOException e){
            System.out.println("IO error" +e );
        }
    }
}
