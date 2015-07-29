import java.io.File;

/**
 * Created by Chizhov-AS on 26.03.2015.
 */
public class FileDemo {

    static void p(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {

        File f1 = new File("C:\\ComponentSetup.log");

        p(f1.getName());
        p(f1.getPath());
        p(f1.getAbsolutePath());
        p(f1.getParent());

        p(f1.exists() ? "True" : "False");
        p(f1.canWrite() ? "True" : "False");
        p(f1.canRead() ? "True" : "False");
        p(f1.isDirectory() ? "True" : "False");
        p(f1.isFile() ? "True" : "False");

        p(f1.lastModified() + "");
        p(f1.length() + "");

    }
}
