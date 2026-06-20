public class TestLogger {

    public static void main(String[] args) {

        // Get Logger instance multiple times
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        // Use the logger
        logger1.log("Application Started");
        logger2.log("User Logged In");
        logger3.log("Data Saved Successfully");

        System.out.println();

        // Print hash codes
        System.out.println("Logger1 HashCode : " + logger1.hashCode());
        System.out.println("Logger2 HashCode : " + logger2.hashCode());
        System.out.println("Logger3 HashCode : " + logger3.hashCode());

        System.out.println();

        // Verify same object
        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));
        System.out.println("logger1 == logger3 : " + (logger1 == logger3));
    }
}