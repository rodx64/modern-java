package rba.modernjava.functionalProgramming.operators;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String[] args) {
        unaryExample();
    }

    private static void unaryExample() {
        UnaryOperator<Integer> plusOne = a -> a + 1;
        System.out.println(plusOne.apply(3));

    }


}
