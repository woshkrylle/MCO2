import java.util.*;
public class VMModel{
    Denominations balance;
    Denominations change;
    ArrayList<ArrayList<Item>> inventory = new ArrayList<>();
    ArrayList<String> itemList = new ArrayList<>();
    int paymentTotal;
    private Controller controller;

    public VMModel(Controller controller){
        this.controller = controller;
        this.balance = new Denominations(100,100,100,100,100,100,100,100);
        this.change = new Denominations(0,0,0,0,0,0,0,0);
        this.paymentTotal = 0;
    }

    public Denominations getBalance(){
        return this.balance;
    }

    public Denominations getChange(){
        return this.change;
    }

    public ArrayList<ArrayList<Item>> getInventory(){
        return this.inventory;
    }

    public ArrayList<String> getItemList(){
        return this.itemList;
    }

    public int getPayment(){
        return this.paymentTotal;
    }
}