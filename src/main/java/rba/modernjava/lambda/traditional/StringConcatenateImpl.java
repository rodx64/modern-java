package rba.modernjava.lambda.traditional;

import rba.modernjava.lambda.StringConcatenate;

public class StringConcatenateImpl implements StringConcatenate {
    @Override
    public String concat(String a, String b) {
        return a.concat(b);
    }
}
