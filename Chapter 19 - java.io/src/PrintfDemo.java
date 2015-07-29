/**
 * Created by Chizhov-AS on 01.04.2015.
 */
public class PrintfDemo {
    public static void main(String[] args) {
        System.out.println("\nНиже следуют некоторые числовые значения " + "В различных форматах.\n");

        System.out.printf("Различные целочисленные фоматы: ");
        System.out.printf("%d % (d %+d %05d/n",3,-3,3,3 );
        System.out.println();

        System.out.printf("Формат с плавающей точкой по умолчанию: %f\n", 1234567.123);
        System.out.printf("Плавающая точка с запятыми: %,f\n", 1234567.123);
        System.out.printf("Отрицательная плавающая точка по умолчанию: %,f\n", -1234567.123);
        System.out.printf("Параметры отрицательной плавающей точки: %,(f\n", -1234567.123);
        System.out.println();

        System.out.printf("Строка из положительных и отрицательных значений: \n");
        System.out.printf("% ,.2f\n% ,.2f\n",3);


    }
}
