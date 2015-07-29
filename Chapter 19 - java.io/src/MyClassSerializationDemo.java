import java.io.Serializable;

/**
 * Created by Chizhov-AS on 03.04.2015.
 */
public class MyClassSerializationDemo implements Serializable {
    String s;
    int i;
    double d;

    public MyClassSerializationDemo (String s,int i, double d){
        this.s = s;
        this.i = i;
        this.d = d;
    }

    public String toString(){
        return "s=" + s + "; i=" + i + "; d=" + d;
    }
}
