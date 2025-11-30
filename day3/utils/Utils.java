package day3.utils;

public class Utils {
    static int data = 1;


    public static int getData() {
        return data;
    }
    public static void showData() {
        System.out.println("Util data: " + getData());
    }
    public void doubleData() {
        System.out.println("Double of data is" + 2*getData());
    }
}
