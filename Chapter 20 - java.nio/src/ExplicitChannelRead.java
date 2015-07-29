import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.channels.*;

/**
 * Created by Chizhov-AS on 06.04.2015.
 */

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filePath = null;

        //Получаем путь к файлу
        try {
            filePath = Paths.get("C:\\test.txt");
        } catch ( InvalidPathException e){
            System.out.println("GetPath error " + e);
            return;
        }

        //Получаем канал к этому файлу
        try (SeekableByteChannel fChan = Files.newByteChannel(filePath)){

            //Зарезервировать буфер
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do{
                // Читать в буфер.
                count = fChan.read(mBuf);

                //ОСтановиться при достижении конца файла
                if(count != -1){

                    //Подготовить буфер для чтения
                    mBuf.rewind();

                    //Читать байты в буфер и отображать их на экране как символы.
                    for(int i=0; i<count; i++){
                        System.out.print((char)mBuf.get());
                    }
                }
            } while (count != -1);

            System.out.println();

        } catch (IOException e){
            System.out.println("IO Error " +e);
        }
    }
}
