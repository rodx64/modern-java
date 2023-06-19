package rba.modernjava.functionalProgramming.consumers;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class ConsumerExampleNumbers {

    public static void main(String[] args) {
        IntConsumer intConsumer = (a) -> System.out.println(a * 10);
        intConsumer.accept(10);

        LongConsumer longConsumer = (b) -> System.out.println(b * b);
        longConsumer.accept(2000L);

        DoubleConsumer doubleConsumer = (c) -> System.out.println(c / 2.5);
        doubleConsumer.accept(12);
    }

}
