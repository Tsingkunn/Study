package practice.baseclass;

import java.nio.file.Path;

public class UppercaseFIleReader extends BaseFileReader {
    public UppercaseFIleReader(Path filePath) {
        super(filePath);
    }

    @Override
    protected String mapFileLine(String line) {
        return line.toUpperCase();
    }
}
