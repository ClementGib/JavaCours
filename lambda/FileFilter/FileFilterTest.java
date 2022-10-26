package JavaCours.lambda.FileFilter;
import java.io.File;
import java.io.FileFilter;

public class FileFilterTest {
    public static void main(String[] args) {
        // Using personnal class that implements the interface
        //JavaFileFilter fileFilter = new JavaFileFilter();

        // Using anonymous class that implements the interface
        // FileFilter fileFilter = new FileFilter() {
        //     @Override
        //     public boolean accept(File file) {
        //         return file.getName().endsWith(".java");
        //     }
        // };

        // Using lambda expression that implements the interface
        FileFilter fileFilter = (File file) -> file.getName().endsWith(".java");

        File directory = new File(".");
        File[] javaFiles = directory.listFiles(fileFilter);
        for (File javaFile : javaFiles) {
            System.out.println(javaFile.getName());
        }
    }
}
