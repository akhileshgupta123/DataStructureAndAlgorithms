/** "Product" */

class Pizza {

  private String dough = "";

  private String sauce = "";

  private String topping = "";

 

  public void setDough(String dough)     { this.dough = dough; }

  public void setSauce(String sauce)     { this.sauce = sauce; }

  public void setTopping(String topping) { this.topping = topping; }

}

 

/** "Abstract Builder" */

abstract class PizzaBuilder {

  protected Pizza pizza;

 

  public Pizza getPizza() { return pizza; }

  public void createNewPizzaProduct() { pizza = new Pizza(); System.out.println("Creation of new pizza product.");}

 

  public abstract void buildDough();

  public abstract void buildSauce();

  public abstract void buildTopping();

}

 

/** "ConcreteBuilder" */

class HawaiianPizzaBuilder extends PizzaBuilder {

  public void buildDough()   { pizza.setDough("cross"); System.out.println("build hawaiian pizza Dough"); }

  public void buildSauce()   { pizza.setSauce("mild"); System.out.println("build hawaiian pizza Sauce"); }

  public void buildTopping() { pizza.setTopping("ham+pineapple"); System.out.println("build hawaiian pizza Topping"); }

}

 

/** "ConcreteBuilder" */

class SpicyPizzaBuilder extends PizzaBuilder {

  public void buildDough()   { pizza.setDough("pan baked"); System.out.println("build spicy pizza Dough");}

  public void buildSauce()   { pizza.setSauce("hot"); System.out.println("build spicy pizza Sauce");}

  public void buildTopping() { pizza.setTopping("pepperoni+salami"); System.out.println("build spicy pizza Topping"); }

}

 

/** "Director" */

class Waiter {

  private PizzaBuilder pizzaBuilder;

 

  public void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }

  public Pizza getPizza() { System.out.println("getting pizza."); return pizzaBuilder.getPizza(); }

 

  public void constructPizza() {

    pizzaBuilder.createNewPizzaProduct();

    pizzaBuilder.buildDough();

    pizzaBuilder.buildSauce();

    pizzaBuilder.buildTopping();

	System.out.println("pizza construction is done.");

  }

}

 

/** A customer ordering a pizza. */

class BuilderExample {

  public static void main(String[] args) {

    Waiter waiter = new Waiter();

    PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();

    PizzaBuilder spicy_pizzabuilder = new SpicyPizzaBuilder();

 

    waiter.setPizzaBuilder( hawaiian_pizzabuilder );

    waiter.constructPizza();

 

    Pizza pizza = waiter.getPizza();

  }

}