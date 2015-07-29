import java.io.File;

/**
 * Created by Chizhov-AS on 26.03.2015.
 */
public class DirList {

    public static void main(String[] args) {

        String dirName = "C:\\-MyAll-\\-Soft-\\SQLiteStudio";
        File f1 = new File(dirName);

        if (f1.isDirectory()){

            System.out.println("Каталог " + dirName);
            String s[] = f1.list();

            for (int i=0; i<s.length; i++){

                File f = new File(dirName + "/" + s[i]);

                if (f.isDirectory()){
                    System.out.println(s[i] + " является каталогом");
                } else {
                    System.out.println(s[i] + " является файлом");
                }
            }
        } else {
            System.out.println(dirName + " is not a directody");
        }
    }
}