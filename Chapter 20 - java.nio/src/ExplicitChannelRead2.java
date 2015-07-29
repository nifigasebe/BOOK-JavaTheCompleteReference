import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * Created by Chizhov-AS on 07.04.2015.
 */
public class ExplicitChannelRead2 {
    public static void main(String[] args) {
        int count;

        //Получаем канал к этому файлу
        try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get("C:\\test.txt"))){

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

        }catch (InvalidPathException e){
            System.out.println("Path error" + e);
        }catch (IOException e){
            System.out.println("IO Error " + e);
        }
    }
}
