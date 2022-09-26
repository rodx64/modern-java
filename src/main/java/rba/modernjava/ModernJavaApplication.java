package rba.modernjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rba.modernjava.lambda.HelloWorld;
import rba.modernjava.lambda.IncrementByInt;
import rba.modernjava.lambda.StringConcatenate;
import rba.modernjava.lambda.traditional.HelloWorldImpl;
import rba.modernjava.lambda.traditional.IncrementByIntFive;
import rba.modernjava.lambda.traditional.RunnableTraditional;
import rba.modernjava.lambda.traditional.StringConcatenateImpl;

@SpringBootApplication
public class ModernJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModernJavaApplication.class, args);
		traditionalWay();
		lambdaWay();
	}

	private static void traditionalWay() {
		HelloWorldImpl helloWorldImpl = new HelloWorldImpl();
		System.out.println(helloWorldImpl.sayHelloWorld());

		IncrementByIntFive incrementByIntFive = new IncrementByIntFive();
		System.out.println(incrementByIntFive.increment(10));

		StringConcatenateImpl stringConcatenateImpl = new StringConcatenateImpl();
		System.out.println(stringConcatenateImpl.concat("Hey ", "Ho!"));

		RunnableTraditional runnableTraditional = new RunnableTraditional();
		new Thread(runnableTraditional.runnable).start();
	}

	private static void lambdaWay() {
		HelloWorld helloWorld = () -> "Hello World!";
		System.out.println(helloWorld.sayHelloWorld());

		IncrementByInt incrementByInt = (x) -> x + 5;
		System.out.println(incrementByInt.increment(10));

		StringConcatenate stringConcatenate = (x, y) -> x.concat(y);
		System.out.println(stringConcatenate.concat("Lets ", "Go!"));

		new Thread(() -> {
			int sum = 0;
			for(int i = 0; i<10; i++) sum += i;
			System.out.println("Runnable Lambda Way: " + sum);
		}).start();
	}

}
