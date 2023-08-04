import java.util.*;
/**
 * The model class responsible for holding all of the program data
 */
public class VMModel{
    Denominations machineBalance;
    Denominations userChange;
    ArrayList<ArrayList<Item>> inventory = new ArrayList<>();
    ArrayList<Item> templateHolder = new ArrayList<>();
    ArrayList<String> itemList = new ArrayList<>();
    int paymentTotal;
    int caloriesTotal;
    private Controller controller;

    /**
     * The constructor method for this class. Initializes every attribute.
     * Sets the default value of the balance denominations to 100
     * Sets the default value of the user denominations to 0
     */
    public VMModel(Controller controller){
        this.controller = controller;
        this.machineBalance = new Denominations(100,100,100,100,100,100,100,100);
        this.userChange = new Denominations(0,0,0,0,0,0,0,0);
        this.paymentTotal = 0;
    }

    /**
     * getMachineBalance aims to reference the value of the denominations in this machine without
     * modifying or altering the variable itself
     * @return machineBalance for this class
     */
    public Denominations getMachineBalance(){
        return this.machineBalance;
    }


    /**
     * getUserChange() aims to access the user's change in denominations without accessing the
     * class' attribute
     * @return userChange of this class
     */
    public Denominations getUserChange(){
        return this.userChange;
    }

    /**
     * getInventory() aims to make a reference to the inventory 2d ITEM array of this classw ithout manipulating the
     * class' actual attributes
     * @return inventory of this class
     */
    public ArrayList<ArrayList<Item>> getInventory(){
        return this.inventory;
    }


    /**
     * getItemList() retrieves the Item list of unique items
     * @return itemList of this class
     */
    public ArrayList<String> getItemList(){
        return this.itemList;
    }

    /**
     * getPayment() gets the total amount of funds put into the machine
     * @return paymentTotal of this class
     */
    public int getPayment(){
        return this.paymentTotal;
    }

    /**
     * getCalories() retrieves the toal calories from the items bought throughout the transaction
     * @return caloriesTotal of this class
     */
    public int getCalories(){
        return this.caloriesTotal;
    }


    /**
     * getTemplate() retrieves the leading item in an index, serving as the template for new additions into stockcs
     * @param index item in particular
     * @return templateHolder
     */
    public Item getTemplate(int index){
        return this.templateHolder.get(index);
    }



    /**
     * setPayment() sets the payment total for the vending machine 
     * @param amount amount of funds
      */
    public void setPayment(int amount){
        this.paymentTotal = amount;
    }

    /**
     * setCalories() sets the total calories for the vending machine in this transaction
     * @param amount amount of cals
      */
    public void setCalories(int amount){
        this.caloriesTotal = amount;
    }
}