# Consumers / BiConsumers

Interfaces that are part of the _java.util.function_ package which has been introduced since Java 8, to implement functional programming in Java. 
It represents a function that takes arguments and produces a result. 

However, these kinds of functions **doesn’t return any value**. 

So, Consumers are useful when it is not required to return any value as they are expected to operate via side-effects. 

- [x] Operate via side-effects (Doesn't return any value)
- [x] Specialized Consumers (IntConsumer, LongConsumer, DoubleConsumer)

### Basic Examples

```
Consumer<String> consumer = (x) -> System.out.println(x.length() + " is the length of x: "+ x);
consumer.accept("Accepting");

// 9 is the length of x: Accepting
```

```
AtomicBoolean isPositive = new AtomicBoolean(Boolean.FALSE);

Consumer<Integer> consumerSideEffect = (y) -> {
    System.out.println(isPositive);
    // false
    
    if(y > 0) isPositive.set(true);
    
    System.out.println(isPositive);
    // true
};

consumerSideEffect.accept(1);
```

```
BiConsumer<Double, Double> biConsumerMultiplication = (a,b) -> 
    System.out.println(BigDecimal.valueOf(a)
            .multiply(BigDecimal.valueOf(b))
            .setScale(2, RoundingMode.CEILING));
    
biConsumerMultiplication.accept(10.2, 11.3);
// 115.26
```


