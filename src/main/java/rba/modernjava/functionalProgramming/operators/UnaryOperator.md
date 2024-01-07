# UnaryOperator
A Functional Interface ```UnaryOperator<T>``` is a part of the java.util.function package which has been introduced since Java 8.

It represents a function which takes in one argument and operates on it.

- [x] Since (T,R) are equal there is only one (T) 
  - _basically the difference of the Function<T,R>_


- [x] Specialized Operators (IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator)

```UnaryOperator<T> overloads the Function<T, T>```

### Basic UnaryOperator Examples
```
UnaryOperator<Integer> plusOne = a -> a + 1;
plusOne.apply(3);
// 4
```
