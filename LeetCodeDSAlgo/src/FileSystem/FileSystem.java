package FileSystem;
import java.util.Scanner;
import java.util.Collections;
import java.util.*;
public class FileSystem {

    Map<String, FileSystemAttributes> directoryDetailsMap;
    PriorityQueue<Directory> directoryHeap;
    HashSet<Directory> isDirectoryPresentInHeap;

    int allFileSize;

    public FileSystem() {
        directoryDetailsMap = new HashMap<>();
        //directoryHeap = new PriorityQueue<Directory>((a, b) -> b.size - a.size);
        directoryHeap = new PriorityQueue<Directory>(new Comparator<Directory>(){
            public int compare(Directory a, Directory b){
                return b.size - a.size;
            }
        });
        isDirectoryPresentInHeap = new HashSet<>();
        this.allFileSize = 0;
    }

    public int getSizeOfAllFiles() {
        return this.allFileSize;
    }

    public List<Directory> getNCollection(int n) {

        if (directoryHeap.size() < n)
            return new ArrayList<>();

        List<Directory> output = new ArrayList<>();
        //PriorityQueue<Directory> tempDirectoryHeap = new PriorityQueue<Directory>((a, b) -> b.size - a.size) ;

        PriorityQueue<Directory> tempDirectoryHeap = new PriorityQueue<Directory>(new Comparator<Directory>(){
            public int compare(Directory a, Directory b){
                return b.size-a.size;
            }
        });

        for (int i = 0; i < n; i++) {
            Directory d = directoryHeap.poll();
            output.add(d);
            tempDirectoryHeap.add(d);
        }

        for (int i = 0; i < n; i++)
            directoryHeap.add(tempDirectoryHeap.poll());

        return output;
    }

    public void addFileToDirectory (String fileName, int size, String dName) {
        File file;
        if (dName.equals("")) {
            file = new File(fileName, size);
            directoryDetailsMap.put(fileName, file);
        } else {
            Directory d = (Directory)directoryDetailsMap.getOrDefault(dName, new Directory(dName));
            file = new File(d, fileName, size);

            d.size += size;
            d.files.add(file);

            if (!isDirectoryPresentInHeap.contains(d)) {
                directoryHeap.add(d);
                isDirectoryPresentInHeap.add(d);
            }

            directoryDetailsMap.put(dName, d);
        }

        allFileSize += size;
    }
}
