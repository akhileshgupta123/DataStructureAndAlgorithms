
  // The classes that implement a concrete strategy should implement this
  // The context class uses this to call the concrete strategy

  //Strategy

  interface IStrategy {
    void execute();
  }
 
  // Implements the algorithm using the strategy interface

  // Concrete Strategy

  class ConcreteStrategyA implements IStrategy {
    public void execute() {
      System.out.println( "Called ConcreteStrategyA.execute()" );
    }
  }
 
  // Concrete Strategy

  class ConcreteStrategyB implements IStrategy  {
    public void execute() {
      System.out.println( "Called ConcreteStrategyB.execute()" );
    }
  }
 
  // Concrete Strategy

  class ConcreteStrategyC implements IStrategy {
    public void execute() {
      System.out.println( "Called ConcreteStrategyC.execute()" );
    }
  }
 
  // Configured with a ConcreteStrategy object and maintains a reference to a Strategy object
  // Context

  class Context {
    IStrategy strategy;
 
    // Constructor
    public Context(IStrategy strategy) {
      this.strategy = strategy;
    }
 
    public void execute() {
      this.strategy.execute();
    }
  }

  //StrategyExample test application
public class StrategyExample {
 
  public static void main(String[] args) {
    Context context;
 
    // Three contexts following different strategies
    context = new Context(new ConcreteStrategyA());
    context.execute();
 
    context = new Context(new ConcreteStrategyB());
    context.execute();
 
    context = new Context(new ConcreteStrategyC());
    context.execute();
  }
}
