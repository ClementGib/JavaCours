package JavaCours.lambda.FileFilter;
import java.io.File;
import java.io.FileFilter;

public class JavaFileFilter implements FileFilter{

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}
