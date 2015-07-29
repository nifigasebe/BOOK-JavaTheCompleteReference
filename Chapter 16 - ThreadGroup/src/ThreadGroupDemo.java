/**
 * Created by Chizhov-AS on 18.03.2015.
 */

public class ThreadGroupDemo {
    public static void main(String[] args) {

        ThreadGroup groupA = new ThreadGroup("Группа А");
        ThreadGroup groupB = new ThreadGroup("Группа B");

        NewThread ob1 = new NewThread("Один", groupA);
        NewThread ob2 = new NewThread("Два", groupA);
        NewThread ob3 = new NewThread("Три", groupB);
        NewThread ob4 = new NewThread("Четыре", groupB);

        System.out.println("\n Вывод из list():");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Прерывается группа А");
        Thread tga[] = new Thread[groupA.activeCount()];
        groupA.enumerate(tga);

        for (int i=0; i < tga.length; i++){
            ((NewThread)tga[i]).mysuspend(); //Приостановить каждый поток
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){
            System.out.println("Главный поток прерван.");
        }

        System.out.println("Возобновление Group A");

        for(int i=0; i<tga.length; i++){
            ((NewThread)tga[i]).myresume(); //Возобновить каждый поток
        }

        try {
            System.out.println("Ожидание останова потоков");

            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        } catch (Exception e){
            System.out.println("Исключение в основном потоке");
        }
        System.out.println("Основной поток завершен");
    }
}
