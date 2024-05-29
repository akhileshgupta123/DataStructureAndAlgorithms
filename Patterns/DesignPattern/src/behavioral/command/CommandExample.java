/**
* This is the command. The customer orders and
* hands it to the waiter.
*/
class Order {
  	private String command;
	public Order(String command) 
	{
		this.command = command;
	}
}// End of class

//The other thing is the waiter who takes the order and forwards it to the cook.

/**
* A waiter is associated with multiple customers and multiple orders
*/
class Waiter {
	public Food takeOrder(Customer cust, Order order)
	{
		Cook cook = new Cook();
		Food food = cook.prepareOrder(order, this);
		return food;
	}
}// End of class

//The waiter calls the prepareFood method of the cook who in turn cooks.

class Cook {
  	public Food prepareOrder(Order order, Waiter waiter)
	{
		Food food = getCookedFood(order);
		return food;
	}
	
	public Food getCookedFood(Order order) 
	{
		Food food = new Food(order);
		return food;
	}
}// End of class

class Food
{
	Food(Order obj)
	{
	}
}

class Customer
{
}

public class CommandExample
{
	public static void main(String args[])
	{
		Waiter obj = new Waiter();
		obj.takeOrder(new Customer(), new Order("Pizza"));
	}
}
