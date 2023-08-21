package rba.modernjava.functionalProgramming.supplier;


import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        suplierTest();
    }

    private static void suplierTest() {
        Supplier<Double>  powerOfTenOnBaseTwo = () -> Math.pow(2, 10);
        System.out.println(powerOfTenOnBaseTwo.get());
    }


}
