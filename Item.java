/**
* Item stores the name of the item, its price, calories, and stock
* as well as operations getting these prices and setting it
* @authors Kurt Hugo and Nauj Agbayani
* @version 1.1
*/
public class Item {
    private String name, process;
    private int price, calories, quantity;

    /**
    * constructor Item() helps in assigning the values for the particular 
    * instance of this class in an object, it also vlidates the input for the number of stocks
    * @param name stores the name
    * @param price stores the price
    * @param calories stores the calories
    * @param process stores the process that the item goes through (for special vending machines)
    */
    public Item(String name, int price, int calories, String process){
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.process= process;
    }

    /**
    *	getName() is a getter for the name attribute of this class
    *	@return name name of the item
    */
    public String getName(){
        return this.name;
    }

    /**
    *	getPrice() is a getter for the price of this particular item
    *	@return price price of the item
    */
    public int getPrice(){
        return this.price;
    }

/**
*	getCalories() is a getter for the calories assigned to this Item
*	@return calories assigned calories to the item
*/  
    public int getCalories(){
        return this.calories;
    }

/**
*	getQuantity() is a getter for the number of stock for this item
*	@return quantity the number of items allocated
*/
    public int getQuantity(){
        return this.quantity;
    }


/**
*	getProcess() is a getter for the process of the item
*	@return string of process should the product be combined with others
*/
public String getProcess(){
    return this.process;
}

/**
*	setPrice() sets the price for this particular item
*	@param n price of the item
*/
    public void setPrice(int n){
        this.price = n;
    }

/**
*	setQuantity() assigns the number of stock this Item
*	@return n assigned stock for the item
*/
    public void setQuantity(int n){
        this.quantity = n;
    }
}


