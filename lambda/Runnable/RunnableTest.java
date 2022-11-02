package JavaCours.lambda.Runnable;
import java.lang.Thread;
import java.lang.Runnable;

public class RunnableTest {
    public static void main (String[] args) throws InterruptedException {
        //Using anonymous class that implements the interface
        // Runnable runnable = new Runnable() {

        //     @Override
        //     public void run() {

        //       for (int index = 0; index < 10; index++) {
        //         System.out.println("Hello World from thread: [" + Thread.currentThread().getName() + "]");
        //       }
        //     }
        // };

        // Using lambda expression that implements the interface
        Runnable runnable = () -> {
          for (int index = 0; index < 10; index++) {
            System.out.println("Hello World from thread: [" + Thread.currentThread().getName() + "]");
                  }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
  }
}
