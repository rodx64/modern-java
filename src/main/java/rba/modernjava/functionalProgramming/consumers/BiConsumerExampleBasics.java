package rba.modernjava.functionalProgramming.consumers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class BiConsumerExampleBasics {

    public static void main(String[] args) {
        // Calculate
        BiConsumer<Integer, Integer> biConsumer = (x,y) -> System.out.println(x * y);
        biConsumer.accept(10, 20);

        // Concatenate
        BiConsumer<String, String> biConsumerConcat = (a,b) -> System.out.println(a+b);
        biConsumerConcat.accept("Hello ", "Consumer");

        // Multiplicate
        BiConsumer<Double, Double> biConsumerMultiplication = (a,b) -> System.out.println(BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).setScale(2, RoundingMode.CEILING));
        biConsumerMultiplication.accept(10.2, 11.3);
    }

}
