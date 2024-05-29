import java.util.*;
public class FileProcessor {
    private int topN;
    private Map<String, Directory> collectionMap;
    private int totalSizeFiles;

    public FileProcessor(int topN) {
        this.topN = topN;
        this.collectionMap = new HashMap<String,Directory>();
        this.totalSizeFiles =0;
    }

    public int getTotalSizeFiles() {
        return totalSizeFiles;
    }


    public void calculateTotalFileSize(int fileSize){
        totalSizeFiles = totalSizeFiles + fileSize;
    }


    public List<String> getTopNCollection(){
        List<String> resultList = new ArrayList<String>();
        PriorityQueue<Directory> pq = new PriorityQueue<Directory>(new Comparator<Directory>(){
            public int compare(Directory d1, Directory d2){
                return d2.getTotalFileSize() - d1.getTotalFileSize();
            }
        });

        for(Map.Entry<String,Directory> entrySet: collectionMap.entrySet()){
            pq.add(entrySet.getValue());
        }

        //if(topN<=pq.size()){
            for(int i=0; i<topN && !pq.isEmpty(); i++){
                Directory dir = pq.poll();
                resultList.add(dir.getCollectionName());
            }

        /*}else{
            int pqSize = pq.size();
            for(int i=0; i<pqSize; i++){
                Directory dir = pq.poll();
                resultList.add(dir.getCollectionName());
            }
        }*/


        return resultList;
    }



    public void populateCollection(String fileName, String collectionName, int fileSize){
        if(collectionName!=null){
            if(collectionMap.containsKey(collectionName)){
                Directory dir = collectionMap.get(collectionName);
                dir.addFileList(fileName,fileSize);
            }else{
                Directory dir = new Directory(collectionName);
                dir.addFileList(fileName,fileSize);
                collectionMap.put(collectionName, dir);
            }
        }
        this.calculateTotalFileSize(fileSize);

    }
}
