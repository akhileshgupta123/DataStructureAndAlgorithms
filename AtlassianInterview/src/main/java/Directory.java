import java.util.*;
public class Directory {
    private String collectionName;
   private List<File> fileList;
   private int totalFileSize;

   public Directory(String collectionName){
       this.collectionName = collectionName;
       fileList = new ArrayList<File>();
       this.totalFileSize = 0;
   }


   public void addFileList(String fileName, int fileSize){
       fileList.add(new File(fileName,fileSize));
       this.totalFileSize = this.totalFileSize + fileSize;
   }

    public int getTotalFileSize() {
        return totalFileSize;
    }

    public String getCollectionName() {
        return collectionName;
    }


}
