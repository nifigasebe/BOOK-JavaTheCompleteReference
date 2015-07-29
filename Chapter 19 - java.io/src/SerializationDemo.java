import java.io.*;

/**
 * Created by Chizhov-AS on 03.04.2015.
 */
public class SerializationDemo {
    public static void main(String[] args) {

        //Serialization

        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("SerializationDemoFile"))){
            MyClassSerializationDemo object1 = new MyClassSerializationDemo("Hello",-7,2.7e10);
            System.out.println("Object1: " + object1);

            objOStrm.writeObject(object1);
        } catch (IOException e){
            System.out.println("Serialization Error: " + e);
        }

        //DeSerialization

        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("SerializationDemoFile"))){
            MyClassSerializationDemo object2 = (MyClassSerializationDemo)objIStrm.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e){
            System.out.println("Deserialization error" + e);
            System.exit(0);
        }
    }
}


