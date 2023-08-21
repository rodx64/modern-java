# Functions

The Function Interface is a part of the _java.util.function_ package which has been introduced since Java 8, to implement functional programming in Java. 

It represents a function that takes arguments and produces a result.

### Structure:  
    **Function<T,R> function**

    - [T]: Type of the input argument
    - [R]: ReturnType of the function


### Methods:
- R apply(T t) : returns the result which is of type R   
  
```
Function<String, String> lowerCaseFunction = (str) -> str.toLowerCase();
lowerCaseFunction.apply("hELlo wOrlD");

// hello world
```

- andThen(): **will be executed after**
```
Function<String, String> lowerCaseFunction = (str) -> str.toLowerCase();
Function<String, Boolean> validateHelloWorld = (str) -> str.equals("hello world");

lowerCaseFunction.andThen(validateHelloWorld).apply("hElLo wORlD");

// true        
```

- compose() : it **will be executed first**.
```
Function<Integer, Integer> multiplyBy3 = (a) -> a * 3;
Function<Integer, Double> half = a -> a / 2.0;
half = half.compose(multiplyBy3);
half.apply(5);
// 7.5        
```

- identity(): returns its own argument
```
Function<Integer, Integer> id = Function.identity();
id.apply(9999);
// 9999
```




