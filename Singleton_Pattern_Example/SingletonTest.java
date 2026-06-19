package Singleton_Pattern_Example;

public class SingletonTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("Processing data.");

        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists.");
        }
    }
}