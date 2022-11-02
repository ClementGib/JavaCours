package JavaCours.lambda.Comparator;
import java.lang.String;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main (String[] args) throws InterruptedException {
      List<String> grettings = Arrays.asList("hello", "bonjour", "xin chao", "hola");

        //Using anonymous class that implements the interface
        // Comparator<String> comparator = new Comparator<String>() {

        //     @Override
        //     public int compare(String s1, String s2) {
        //       return Integer.compare(s1.length(), s2.length());
        //     }
        // };

        // Using lambda expression that implements the interface
        Comparator<String> comparator = (String s1, String s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };

        displayList(grettings);
        grettings.sort(comparator);
        displayList(grettings);
  }

  private static void displayList(List<String> list) {
    for (String element : list) {
      System.out.println(element);
    }
    System.out.println();
  }
}
