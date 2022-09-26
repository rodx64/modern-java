package rba.modernjava.lambda.traditional;

public class RunnableTraditional {

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int sum = 0;
            for (int i=0; i<10;i++){
                sum += i;
            }

            System.out.println("Runnable Traditional Way: " + sum);
        }
    };

}
