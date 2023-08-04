import java.util.*;
/** 
 * CustomItem keeps track of the data for the custom item.
 * It keeps track of the list of items, the amount of items,
 * the total price and the total calories.
 */
public class CustomItem {
    private ArrayList<Item> cart;
    private int itemCount, priceTotal, caloriesTotal;

    public CustomItem(){
        this.cart = new ArrayList<>();
        this.itemCount = 0;
        this.priceTotal = 0;
        this.caloriesTotal = 0;
    }

/**
*	addItem() adds the item to the ArrayList of type Item in the class
*	@param item this is the item to be added on the array.
*/
    public void addItem(Item item){
        this.cart.add(item);
        this.itemCount++;
        this.priceTotal += item.getPrice();
        this.caloriesTotal += item.getCalories();
    }

/**
*	getCart() is a getter function for the Item ArrayList named cart
*	@return cart transaction within this instance
*/
    public ArrayList<Item> getCart(){
        return this.cart;
    }
/**
*	getItemCount() is a getter for the total item count
*	@return itemCount the item count within this instance
*/
    public int getItemCount(){
        return this.itemCount;
    }
/**
*	getPriceTotal() is a getter for the total payable amount
*	@return priceTotal payable amount in total within this instance
*/
    public int getPriceTotal(){
        return this.priceTotal;
    }
/**
*	getCaloriesTotal() is a getter for the total calories
*	@return caloriesTotal calories within this instance
*/
    public int getCaloriesTotal(){
        return this.caloriesTotal;
    }
}
