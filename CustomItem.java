import java.util.*;
/**
*	Transaction is a class that stores the operations related to one whole transaction
*	in a vending machine. It calculates the items, total price, total calories, and change
*	incurred through the instance.
*	@author Kurt Justine Hugo and Nauj Agbayani
*	@version 1.2
*/
public class CustomItem {
    private ArrayList<Item> cart = new ArrayList<>();
    private int itemCount = 0, priceTotal = 0, caloriesTotal = 0, paymentTotal = 0;
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
*	findItem() looks for the item and its existence by going through the
*	ArrayList of type Item and checking if the key name matches with the item name
*	@param name String name of the item to be used as key
*	@return item data type item that would be used/found
*	@return null if data does not exist
*/
    public Item findItem(String name){
        for(Item item : cart){
            if(item.getName()==name) return item;
        }
        return null;
    }

    /**
*	addPaymentTotal() increments the amount specified to the total 
*	payment in this transaction
*	@param amount money added to payment/credit
*/
    public void addPaymentTotal(int amount){
        this.paymentTotal += amount;
    }
/**
*	setPaymentTotal() explicity states and assigns the total amount 
*	of credits in this transaction
*	@param amount actual credit/total payment
*/
    public void setPaymentTotal(int amount){
        this.paymentTotal = amount;
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
*	getPriceTotal() is a getter for the total calories
*	@return caloriesTotal calories within this instance
*/
    public int getCaloriesTotal(){
        return this.caloriesTotal;
    }
/**
*	getPriceTotal() is a getter for the total payment/credit
*	@return totalPayment credits stored within this instance
*/
    public int getPaymentTotal(){
        return this.paymentTotal;
    }
}
