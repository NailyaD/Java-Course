package de.telran;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        copyFile("C:\\Users\\Naily\\Downloads\\Доки_JC.zip", "C:\\Users\\Naily\\Desktop");
    }

    public static void copyFile(String from, String to) {
        Path sourceFile = Paths.get(from);
        Path targetDir = Paths.get(to);
        Path targetFile = targetDir.resolve(sourceFile.getFileName());

        try {

            Files.copy(sourceFile, targetFile);

        } catch (FileAlreadyExistsException ex) {
            System.err.format("File %s already exists.", targetFile);
        } catch (IOException ex) {
            System.err.format("I/O Error when copying file");
        }
    }
}
