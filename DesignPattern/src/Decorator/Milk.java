package Decorator;

public class Milk implements Coffee{
    private final Coffee coffee;

    public Milk(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
}
