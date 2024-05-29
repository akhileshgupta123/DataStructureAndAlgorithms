import java.util.*;
 
 // abstract expression

interface Expression {
    public void interpret(Stack<Integer> s);
}
 
// TerminalExpression

class TerminalExpression_Number implements Expression {
    private int number;
    public TerminalExpression_Number(int number)       { this.number = number; }
    public void interpret(Stack<Integer> s)  { s.push(number); }
}
 
// TerminalExpression

class TerminalExpression_Plus implements Expression {
    public void interpret(Stack<Integer> s)  { s.push( s.pop() + s.pop() ); }
}
 
// TerminalExpression

class TerminalExpression_Minus implements Expression {
    public void interpret(Stack<Integer> s)  { s.push( - s.pop() + s.pop() ); }
}
 
class Parser {
    private ArrayList<Expression> parseTree = new ArrayList<Expression>(); // only one NonTerminal Expression here
 
    public Parser(String s) {
        for (String token : s.split(" ")) {
            if      (token.equals("+")) parseTree.add( new TerminalExpression_Plus() );
            else if (token.equals("-")) parseTree.add( new TerminalExpression_Minus() );
            else                        parseTree.add( new TerminalExpression_Number(Integer.valueOf(token)) );
        }
    }
 
    public int evaluate() {
		
		// Global Context object
        Stack<Integer> context = new Stack<Integer>(); 
        for (Expression e : parseTree) e.interpret(context);
        return context.pop();
    }
}

// Client
 
class InterpreterExample {
    public static void main(String[] args) {
		System.out.println("This is postfix expression example.");
        String expression = "42 4 2 - +";
        Parser p = new Parser(expression);
        System.out.println("'" + expression +"' equals " + p.evaluate());
    }
}
