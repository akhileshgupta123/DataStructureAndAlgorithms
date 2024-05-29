package Decorator;
/*
Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
The decorator pattern allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class.
The decorator pattern uses a "decorator" class that can be used to add or override behavior for an existing class.
The decorator pattern can be used to add new behavior to an existing class without the need to create a new subclass.
*/
public class DecoratorClient {
    public static void main(String args[]){
        Coffee coffee = new SimpleCoffee();
        System.out.println("coffee with normal");
        System.out.println("The cost :"+coffee.getCost() +" The description : "+coffee.getDescription());

        Coffee milkCoffee = new Milk(coffee);

        System.out.println("coffee with decorator :");
        System.out.println("The cost :"+milkCoffee.getCost() +" The description : "+milkCoffee.getDescription());

    }
}
