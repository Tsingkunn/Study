package practice.baseclass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL location = FileReaderTest.class.getClassLoader().getResource("HelloWorld.txt");
        if (location != null) {
            Path path = Paths.get(location.toURI());
            BaseFileReader lowerFileReader = new LowercaseFileReader(path);
            BaseFileReader upperFileReader = new UppercaseFIleReader(path);
            System.out.println(lowerFileReader.readFile());
            System.out.println(upperFileReader.readFile());
        }
    }
}
