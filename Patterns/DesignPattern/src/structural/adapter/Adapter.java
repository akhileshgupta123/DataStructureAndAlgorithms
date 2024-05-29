//Target

interface Stack
{
  void push (int o);
  int pop ();
  int top ();
}
 
/* DoubleLinkedList is the adaptee class */
// Adaptee

class DList
{
  public void insert (int pos, int o) { System.out.println("Insertion in doubly link list."); }
  public void remove (int pos) { System.out.println("deletion in doubly link list."); }
 
  public void insertHead (int o) { System.out.println("Insertion on head in doubly link list."); }
  public void insertTail (int o) { System.out.println("Insertion on tail in doubly link list."); }
 
  public int removeHead () { System.out.println("deletion on head in doubly link list."); return -1; }
  public int removeTail () { System.out.println("deletion on tail in doubly link list.");return -1; }
 
  public int getHead () {  System.out.println("get head of doubly link list.");return -1;}
  public int getTail () {  System.out.println("get tail of doubly link list.");return -1; }
}
 
/* Adapt DList class to Stack interface is the adapter class */
// Adapter

class DListImpStack extends DList implements Stack
{
  public void push (int o) {
	   System.out.println("push data in stack start.");
		insertTail (o);
	   System.out.println("push data in stack done.");
  }
 
  public int pop () {
	System.out.println("pop data from stack start.");
    return removeTail ();
  }
 
  public int top () {
	System.out.println("get top data from stack.");
    return getTail ();
  }
}

// Client

public class Adapter
{
	public static void main(String args[])
	{
		DListImpStack obj = new DListImpStack();
		obj.push(1);
		obj.push(2);
		obj.pop();
		obj.top();
	}
}
