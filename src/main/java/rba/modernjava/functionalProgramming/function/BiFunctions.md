# BiFunctions

The BiFunction Interface is a part of the _java.util.function_ package which has been introduced since Java 8, to implement functional programming in Java. 

It represents a function which takes in two arguments and produces a result.

### Structure:  
    **BiFunction<T,U,R> biFunction**

    - [T]: Type of the first argument
    - [U]: Type of the second argument
    - [R]: ReturnType of the function


### Methods:
- R apply(T t, U u) : returns the result which is of type R   
  
```
BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
multiply.apply(2,3);
// 6
```

- andThen(Function<? super R, ? extends V> after): Where **V** is the type of output of the after function
```
Function<Integer, Integer> multiplyBy3 = (a) -> a * 3;
multiply = multiply.andThen(multiplyBy3);
multiply.apply(2, 3);       
// 18
```

