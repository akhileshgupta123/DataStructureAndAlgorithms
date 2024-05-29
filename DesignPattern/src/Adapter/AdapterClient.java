package Adapter;

/*
Adapter pattern works as a bridge between two incompatible interfaces.
The adapter pattern allows incompatible classes to work together by converting the interface of one class into an interface that another class expects.
The adapter pattern uses an "adapter" class that can adapt the interface of an existing class to the interface that is expected by other classes.
The adapter pattern can be used to create a link between classes that couldn't otherwise be linked due to incompatible interfaces.
We are demonstrating use of Adapter pattern via following example in which an audio player device can play mp3 files only and wants to use an
advanced audio player capable of playing vlc and mp4 files.
*/

public class AdapterClient {
    public static void main(String args[]){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
