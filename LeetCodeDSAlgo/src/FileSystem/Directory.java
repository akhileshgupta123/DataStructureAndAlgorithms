package FileSystem;


import java.util.*;

public class Directory implements FileSystemAttributes{
    String name;
    List<File> files;
    int size;

    public Directory (String name) {
        this.name = name;
        files = new ArrayList<>();
        this.size = 0;
    }
}
