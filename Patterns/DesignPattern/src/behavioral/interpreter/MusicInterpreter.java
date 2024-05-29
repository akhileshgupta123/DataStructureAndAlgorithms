class Note
{
}

class Frequency
{
}

class NotesInterpreter {
  	private Note note;

/**
* This method gets the note from the keys pressed.
* Them, this sets it at a global level.
*/
	public void getNoteFromKeys(Note note) {
	Frequency freq = getFrequency(note);
	sendNote(freq);
	}

/**
* This method gets the frequency for the note.
* Say, if the note is "Sa", it will return 256.
*/
	private Frequency getFrequency(Note note) {
	// Get the frequency from properties
	// file using ResourceBundle
	// and return it.

	return new Frequency();
	}

/**
* This method forwards the frequency to the
* sound producer which is some electronic instrument which
* plays the sound.
*/
	private void sendNote(Frequency freq) {
	NotesProducer producer = new NotesProducer();
	producer.playSound(freq);
	}
}// End of class


class NotesProducer {
  	private Frequency freq;

	public NotesProducer() {
	this.freq = freq;
	}

/**
* This method produces the sound wave of the
* frequency it gets.
*/
	public void playSound(Frequency freq) {
	}
}// End of class

public class MusicInterpreter
{
	public static void main(String args[])
	{
		NotesInterpreter obj = new NotesInterpreter();
		obj.getNoteFromKeys(new Note());
	}
}
