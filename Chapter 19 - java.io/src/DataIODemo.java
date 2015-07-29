import java.io.*;

/**
 * Created by Chizhov-AS on 01.04.2015.
 */
public class DataIODemo {
    public static void main(String[] args) {

        //запись данных

        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("Не удается открыть out файл");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }

        //Чтение данных

        try (DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("Значения: " + " " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            System.out.println("Не удается открыть in файл");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}