package rba.modernjava.functionalProgramming.operators;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {
        binaryExample();
    }

    private static void binaryExample() {
        BinaryOperator<Integer> multiply = (a, b) -> a * b ;
        System.out.println(multiply.apply(3, 3));

        Comparator<Integer> comparator = Integer::compareTo;
        BinaryOperator<Integer> maxBinary = BinaryOperator.maxBy(comparator);
        BinaryOperator<Integer> minBinary = BinaryOperator.minBy(comparator);

        System.out.println(maxBinary.apply(10, 11));
        System.out.println(minBinary.apply(10, 11));
    }


}
