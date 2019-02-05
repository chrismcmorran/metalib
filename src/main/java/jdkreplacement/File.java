package jdkreplacement;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Scanner;

public class File extends java.io.File {
    public File(String pathname) {
        super(pathname);
    }

    public File(String parent, String child) {
        super(parent, child);
    }

    public File(java.io.File parent, String child) {
        super(parent, child);
    }

    public File(URI uri) {
        super(uri);
    }

    /**
     * Reads the contents of the File.
     * @return A String.
     */
    public String Contents() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(this);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
