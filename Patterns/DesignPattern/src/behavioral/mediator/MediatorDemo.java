import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// mediator interface
interface MediatorIntf
{
	void book() ;
	void view();
	void search();
}

//concrete mediator

class Mediator {
    BtnView btnView;
    BtnSearch btnSearch;
    BtnBook btnBook;
    LblDisplay show;
    //....
    void registerView(BtnView v) {
        btnView = v;
    }
    void registerSearch(BtnSearch s) {
        btnSearch = s;
    }
    void registerBook(BtnBook b) {
        btnBook = b;
    }
    void registerDisplay(LblDisplay d) {
        show = d;
    }
    void book() {
       btnBook.setEnabled(false);
       btnView.setEnabled(true);
       btnSearch.setEnabled(true);
       show.setText("booking...");
    }
    void view() {
       btnView.setEnabled(false);
       btnSearch.setEnabled(true);
       btnBook.setEnabled(true);
       show.setText("viewing...");
    }
    void search() {
       btnSearch.setEnabled(false);
       btnView.setEnabled(true);
       btnBook.setEnabled(true);
       show.setText("searching...");
    }
}

//colleague interface
interface Command {
    void execute();
}

//concrete colleague

class BtnView extends JButton implements Command {
    Mediator med;
    BtnView(ActionListener al, Mediator m) {
        super("View");
        addActionListener(al);
        med = m;
        med.registerView(this);
    }
    public void execute() {
       med.view();
    }
}

//concrete colleague

class BtnSearch extends JButton implements Command {
    Mediator med;
    BtnSearch(ActionListener al, Mediator m) {
        super("Search");
        addActionListener(al);
        med = m;
        med.registerSearch(this);
    }
    public void execute() {
       med.search();
    }
}

//concrete colleague

class BtnBook extends JButton implements Command {
    Mediator med;
    BtnBook (ActionListener al, Mediator m) {
        super("Book");
        addActionListener(al);
        med = m;
        med.registerBook(this);
    }
    public void execute() {
       med.book();
    }
}

class LblDisplay extends JLabel{
    Mediator med;
    LblDisplay (Mediator m) {
        super("Just start...");
        med = m;
        med.registerDisplay(this);
        setFont(new Font("Arial",Font.BOLD,24));
    }
}
class MediatorDemo extends JFrame implements ActionListener {
    Mediator med = new Mediator();
    MediatorDemo() {
       JPanel p = new JPanel();
       p.add(new BtnView(this,med));
       p.add(new BtnBook(this,med));
       p.add(new BtnSearch(this, med));
       getContentPane().add(new LblDisplay(med), "North");
       getContentPane().add(p, "South");
       setSize(400,200);
       setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae) {
        Command comd = (Command)ae.getSource();
        comd.execute();
    }
	public static void main(String[] args) {
	    new MediatorDemo();
    }
}
