/**
 * Created by Chizhov-AS on 18.03.2015.
 */

public class NewThread extends Thread {
    boolean suspendFlag;

    NewThread(String threadname, ThreadGroup tgOB) {
        super(tgOB, threadname);
        System.out.println("Новый поток: " + this);
        suspendFlag = false;
        start();
    }

    // Точка входа потока
    public void run() {
        try {
            for (int i=5; i>0; i--){
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Исключение в " + getName());
        }
        System.out.println(getName() + " завершается");
    }

    synchronized void mysuspend(){
        suspendFlag = true;
    }

    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }

}
