import java.util.*;

 // Subject

interface Image {
    public void displayImage();
}
 
// Real Subject

class RealImage implements Image {
    private String filename;
    public RealImage(String filename) { 
        this.filename = filename;
        loadImageFromDisk();
    }
 
    private void loadImageFromDisk() {
        // Potentially expensive operation
        // ...
        System.out.println("Loading   "+filename);
    }
 
    public void displayImage() { System.out.println("Displaying "+filename); }
}
 
// Proxy

class ProxyImage implements Image {
    private String filename;
    private Image image;
 
    public ProxyImage(String filename) { this.filename = filename; }
    public void displayImage() {
        if (image == null) {
            image = new RealImage(filename); // load only on demand
        }
        image.displayImage();
    }
}

// Client

public class ProxyExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");
        Image image3 = new ProxyImage("HiRes_10MB_Photo3");      
 
        image1.displayImage(); // loading necessary
        image2.displayImage(); // loading necessary
        image2.displayImage(); // no loading necessary; already done
        // the third image will never be loaded - time saved!
    }
}
