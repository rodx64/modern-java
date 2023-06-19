package rba.modernjava.functionalProgramming.consumers;

import java.util.function.Consumer;

public class ConsumerExampleBasics {

    public static void main(String[] args) {

        Consumer<String> consumer = (x) -> System.out.println(x.length() + " the value of x: "+ x);
        consumer.accept("Accepting");

        // Consumer with block statement
        Consumer<Integer> consumerInt = (i) -> {
            System.out.println(" i x i = " + i * i);
            System.out.println(" i / i = " + i / i);
        };
        consumerInt.accept(10);

    }

}
