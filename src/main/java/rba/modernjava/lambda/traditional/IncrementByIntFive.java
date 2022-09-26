package rba.modernjava.lambda.traditional;

import rba.modernjava.lambda.IncrementByInt;

public class IncrementByIntFive implements IncrementByInt {
    @Override
    public int increment(int a) {
        return a + 5;
    }
}
