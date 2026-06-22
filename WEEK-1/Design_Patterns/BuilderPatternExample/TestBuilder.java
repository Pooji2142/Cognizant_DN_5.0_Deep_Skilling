public class TestBuilder {

    public static void main(String[] args) {

        // Gaming Computer
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32 GB")
                .setStorage("2 TB SSD")
                .build();

        System.out.println("Gaming Computer:");
        gamingComputer.display();

        System.out.println();

        // Office Computer
        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16 GB")
                .setStorage("512 GB SSD")
                .build();

        System.out.println("Office Computer:");
        officeComputer.display();
    }
}