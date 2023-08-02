import java.util.*;
public class VMModel{
    Denominations machineBalance;
    Denominations userChange;
    ArrayList<ArrayList<Item>> inventory = new ArrayList<>();
    ArrayList<String> itemList = new ArrayList<>();
    int paymentTotal;
    private Controller controller;

    public VMModel(Controller controller){
        this.controller = controller;
        this.machineBalance = new Denominations(100,100,100,100,100,100,100,100);
        this.userChange = new Denominations(0,0,0,0,0,0,0,0);
        this.paymentTotal = 0;
    }

    public Denominations getMachineBalance(){
        return this.machineBalance;
    }

    public Denominations getUserChange(){
        return this.userChange
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