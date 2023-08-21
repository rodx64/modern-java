package rba.modernjava.functionalProgramming.consumers;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class ConsumerExampleBasics {

    public static void main(String[] args) {

        Consumer<String> consumer = (x) -> System.out.println(x.length() + " is the length of x: "+ x);
        consumer.accept("Accepting");

        // Consumer with block statement
        Consumer<Integer> consumerInt = (i) -> {
            System.out.println(" i x i = " + i * i);
            System.out.println(" i / i = " + i / i);
        };
        consumerInt.accept(10);

        AtomicBoolean isPositive = new AtomicBoolean(Boolean.FALSE);
        Consumer<Integer> consumerSideEffect = (y) -> {
            System.out.println(isPositive);
            if(y > 0) isPositive.set(true);
            System.out.println(isPositive);
        };
        consumerSideEffect.accept(10);


    }

}
