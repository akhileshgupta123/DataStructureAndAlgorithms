// the Window interface
//Component

interface Window {
    public void draw(); // draws the Window
    public String getDescription(); // returns a description of the Window
}
 
 
// implementation of a simple Window without any scrollbars
//Concrete Component

class SimpleWindow implements Window {
    public void draw() {
        // draw window
		System.out.println("Drawing Simple Window.");
    }
 
    public String getDescription() {
        return "simple window";
    }
}


// abstract decorator class - note that it implements Window
//Decorator

abstract class WindowDecorator implements Window {
    protected Window decoratedWindow; // the Window being decorated
 
    public WindowDecorator (Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }
}
 
 
// the first concrete decorator which adds vertical scrollbar functionality
//Concrete Decorator

class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator (Window decoratedWindow) {
        super(decoratedWindow);
    }
 
    public void draw() {     
        decoratedWindow.draw();
		drawVerticalScrollBar();
    }
 
    private void drawVerticalScrollBar() {
        // draw the vertical scrollbar
		System.out.println("Drawing Vertical ScrollBar.");		
    }
 
    public String getDescription() {
        return decoratedWindow.getDescription() + ", including vertical scrollbars";
    }
}
 
 
// the second concrete decorator which adds horizontal scrollbar functionality
//Concrete Decorator

class HorizontalScrollBarDecorator extends WindowDecorator {
    public HorizontalScrollBarDecorator (Window decoratedWindow) {
        super(decoratedWindow);
    }
 
    public void draw() {
		decoratedWindow.draw();
        drawHorizontalScrollBar();       
    }
 
    private void drawHorizontalScrollBar() {
        // draw the horizontal scrollbar
		System.out.println("Drawing Horizontal ScrollBar.");	
    }
 
    public String getDescription() {
        return decoratedWindow.getDescription() + ", including horizontal scrollbars";
    }
}

// Client

public class DecoratedWindowTest {
    public static void main(String[] args) {
        // create a decorated Window with horizontal and vertical scrollbars
        Window decoratedWindow = new HorizontalScrollBarDecorator (
                new VerticalScrollBarDecorator(new SimpleWindow()));
 
        // print the Window's description
        System.out.println(decoratedWindow.getDescription());

		// print draw method
		decoratedWindow.draw();
    }
}
