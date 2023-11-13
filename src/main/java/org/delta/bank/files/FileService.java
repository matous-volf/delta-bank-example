package org.delta.bank.files;

import com.google.inject.Singleton;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

@Singleton
public class FileService {
    public void writeFile(String fileName, String content) throws IOException {
        Path file = Paths.get(fileName);
        Files.write(file, Collections.singleton(content), StandardCharsets.UTF_8);
    }

    public String readFile(String fileName) throws IOException {
        Path filePath = Path.of(fileName);
        return Files.readString(filePath);
    }

    public boolean fileExists(String fileName) {
        Path filePath = Path.of(fileName);
        return Files.exists(filePath);
    }
}
