import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Controller {
    private MainMenuView mainMenu;
    private RegularVMView rvmView;
    private SpecialVMView svmView;
    private MaintenanceView mntnView;
    private VMModel vendingMachine;
    private JFrame frame;
    private CardLayout cardLayout;
    private boolean existing = false;

    /**
     * Creates an object for the Controller of the GUI
     */
    public Controller(){
        vendingMachine = new VMModel(this);
        this.frame = new JFrame("Vending Machine Factory");
        this.frame.setLayout(new CardLayout());
        this.cardLayout = (CardLayout) frame.getContentPane().getLayout();
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(480, 360);
    }

    /**
     * Initializes the reference variable to the Main Menu View
     * @param mainMenu
     */
    public void setMainMenu(MainMenuView mainMenu){
        this.mainMenu = mainMenu;
    }

    /**
     * Initializes the reference variable to the Vending Machine View
     * @param rvmView
     */
    public void setRVMView(RegularVMView rvmView){
        this.rvmView = rvmView;
    }

    /**
     * Initializes the reference variable to the Special Vending Machine View
     * @param svmView
     */
    public void setSVMView(SpecialVMView svmView){
        this.svmView = svmView;
    }

    public void setMNTNView(MaintenanceView mntnView){
        this.mntnView = mntnView;
    }

    /**
     * Makes the frame for the program visible and shifts the
     * panel to the Main Menu
     */
    public void Run(){
        this.frame.setVisible(true);
        cardLayout.show(frame.getContentPane(), "Main Card");
    }

    /**
     * Instantiates a VMModel or SpecialVMModel based on user input
     * If a choice was created that is either 0 or 1 it will shift
     * the panel to the Create Vending Machine panel
     */
    public void createVM(int choice){
        if(choice == 0){
            vendingMachine = new VMModel(this);
            cardLayout.show(frame.getContentPane(), "Create Card");
        }else if (choice == 1){
            this.vendingMachine = new SpecialVMModel(this);
            cardLayout.show(frame.getContentPane(), "Create Card");
        }
        existing = true;
    }

    /**
     * If there is a vending machine that is created, it will shift
     * the panel to the Vending Machine Features GUI.
     * If not, it will show a warning message
     */
    public void testVM(){
        if(existing){
            rvmView.initializeItemButtons();
            svmView.initializeItemButtons();
            frame.revalidate();
            frame.repaint();
            cardLayout.show(frame.getContentPane(), "Vending Features Card");
        }else{
            String message = "There is no existing vending machine";
            String title = "Warning!";
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);;
        }
    }

    /**
     * 
     * @return the reference to the JFrame object of the GUI
     */
    public JFrame getFrame(){
        return this.frame;
    }

    /**
     * 
     * @return the reference to the CardLayout of the GUI
     */
    public CardLayout getCardLayout(){
        return this.cardLayout;
    }

    /**
     * Checks if an item already exists in the inventory/item list
     * @param itemName
     * @return  true or false of whether the item exists
     */
    public boolean checkForItem(String itemName){
        if(vendingMachine.getItemList().contains(itemName)) return true;
        else return false;
    }

    /**
     * If there are less than 8 items in the slots, creates a new
     * unique item and adds it to the item list and inventory
     * @param name
     * @return  true or false of whether there is less than 8 items or not
     */
    public boolean newItemListEntry(String name){
        if(vendingMachine.getItemList().size()<8) {
            vendingMachine.getItemList().add(name);
            cardLayout.show(frame.getContentPane(), "Item Card");
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Available slots are already filled", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     * This adds an already existing item to the inventory by "Cloning"
     * the first item of that type and adding the clone to the inventory
     * @param name
     */
    public boolean addItemToInventory(String name){
        int index = vendingMachine.getItemList().indexOf(name);
        if(vendingMachine.getInventory().get(index).size()<10){
            int price = vendingMachine.getInventory().get(index).get(0).getPrice();
            int calories = vendingMachine.getInventory().get(index).get(0).getCalories();
            String process = vendingMachine.getInventory().get(index).get(0).getProcess();
            Item existingItem = new Item(name, price, calories, process);
            vendingMachine.getInventory().get(index).add(existingItem);
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "This slot is already full", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     * This adds a new Item to the inventory, which is a 2d array of items where each new addition takes up
     * a new row upon being unique, and takes up the same row if duplicated.
     * @param price 
     * @param calories
     * @param process
     */
    public void addItemToInventory(int price, int calories, String process){
        String name = vendingMachine.getItemList().get(vendingMachine.getItemList().size()-1);
        Item newItem = new Item (name, price, calories, process);
        ArrayList<Item> inventoryRow = new ArrayList<>();
        inventoryRow.add(newItem);
        vendingMachine.getInventory().add(inventoryRow);
    }


    /**
     * getSlotCount gets the size of the item list as shown in the vending machine model,
     * essentially serving as a getter method for the number of unique items sold in the vending machine
     * @return 
     */
    public int getSlotCount(){
        return vendingMachine.getItemList().size();
    }

    /**
     * returns how much there are of a specific item
     * @param name
     * @return
     */
    public int getItemCount(String name){
        int i = vendingMachine.getItemList().indexOf(name);
        return vendingMachine.getInventory().get(i).size();
    }

    /**
     * returns how much there are of a specific item
     * @param index
     * @return
     */
    public int getItemCount(int index){
        return vendingMachine.getInventory().get(index).size();
    }

    /**
     * returns the index of an already existing item
     * @param name
     * @return
     */
    public int getItemIndex(String name){
        return vendingMachine.getItemList().indexOf(name);
    }

    /**
     * Increments the value of the payment and the number of denominations
     * of that specific denomination in the vending machine 
     * @param amount
     * @param denomination
     * @return
     */
    public int updateTotalPayment(int amount, int denomination){
        int initialAmmount = vendingMachine.getPayment();
        vendingMachine.setPayment(initialAmmount+amount);
        switch(denomination){
            case 500:
                vendingMachine.getMachineBalance().setFiveHundred(vendingMachine.getMachineBalance().getFiveHundred()+1);
                break;
            case 200:
                vendingMachine.getMachineBalance().setFiveHundred(vendingMachine.getMachineBalance().getTwoHundred()+1);
                break;
            case 100:
                vendingMachine.getMachineBalance().setFiveHundred(vendingMachine.getMachineBalance().getOneHundred()+1);
                break;
            case 50:
                vendingMachine.getMachineBalance().setFiveHundred(vendingMachine.getMachineBalance().getFifty()+1);
                break;
            case 20:
                vendingMachine.getMachineBalance().setFiveHundred(vendingMachine.getMachineBalance().getTwenty()+1);
                break;
            case 10:
                vendingMachine.getMachineBalance().setFiveHundred(vendingMachine.getMachineBalance().getTen()+1);
                break;
            case 5:
                vendingMachine.getMachineBalance().setFiveHundred(vendingMachine.getMachineBalance().getFive()+1);
                break;
            case 1:
                vendingMachine.getMachineBalance().setFiveHundred(vendingMachine.getMachineBalance().getOne()+1);
                break;
            }
        return vendingMachine.getPayment();
    }

    /**
     * Shifts the panel to the Items GUI that allows 
     * the user to choose and buy items
     */
    public void showItemMenu(){
        if(vendingMachine instanceof SpecialVMModel){
            cardLayout.show(frame.getContentPane(), "Special Items Card");
            svmView.updateLabels();
        }else{
            rvmView.updateLabels();
            cardLayout.show(frame.getContentPane(), "Regular Items Card");
        }
    }

    /**
     * returns the index of an already existing item
     * @param index
     * @return
     */
    public String getItemName(int index){
        return vendingMachine.itemList.get(index);
    }

    /**
     * If the item that the user chose still has stock, this method will
     * remove the item from the inventory. It will also update the remaining
     * change, the total price, and the total calories of the transaction
     * @param index
     */
    public void removeItem(int index){
        if(vendingMachine.getPayment()>vendingMachine.getInventory().get(index).get(0).getPrice())
        if(vendingMachine.getInventory().get(index).size()>0){
            int currentPayment = vendingMachine.getPayment();
            int price = vendingMachine.getInventory().get(index).get(0).getPrice();
            vendingMachine.setPayment(currentPayment - price);
            int currentCalories = vendingMachine.getCalories();
            int itemCalories = vendingMachine.getInventory().get(index).get(0).getCalories();
            vendingMachine.setCalories(currentCalories+itemCalories);
            vendingMachine.getInventory().get(index).remove(vendingMachine.getInventory().get(index).size()-1);
        }

    }

    /**
     * returns the total payment or the remaining change of the user
     * @return
     */
    public int getPaymentTotal(){
        return vendingMachine.getPayment();
    }

    /**
     * returns the total amount of calories that the user has bought
     * @return
     */
    public int getCaloriesTotal(){
        return vendingMachine.getCalories();
    }

    /**
     * Ends the transaction, calculates the change of the user,
     * and updates the remaining cash of the machine
     */
    public void checkOut(){
        int c = vendingMachine.getPayment();
        int bFiveh = vendingMachine.machineBalance.getFiveHundred(), 
            bTwoh = vendingMachine.machineBalance.getTwoHundred(), 
            bOneh = vendingMachine.machineBalance.getOneHundred(), 
            bFifty = vendingMachine.machineBalance.getFifty(), 
            bTwenty = vendingMachine.machineBalance.getTwenty(), 
            bTen = vendingMachine.machineBalance.getTen(), 
            bFive = vendingMachine.machineBalance.getFive(),
            bOne = vendingMachine.machineBalance.getOne();
        int cFiveh = 0, 
            cTwoh = 0, 
            cOneh = 0, 
            cFifty = 0, 
            cTwenty = 0, 
            cTen = 0, 
            cFive = 0,
            cOne = 0;

        
        while(bFiveh>0 && c>=500){
            c -= 500;
            bFiveh--;
            cFiveh++;
            vendingMachine.userChange.setFiveHundred(vendingMachine.userChange.getFiveHundred()+1);
            vendingMachine.userChange.setFiveHundred(vendingMachine.machineBalance.getFiveHundred()-1);
        }
        while(bTwoh>0 && c>=200){
            c -= 200;
            bTwoh--;
            cTwoh++;
            vendingMachine.userChange.setTwoHundred(vendingMachine.userChange.getTwoHundred()+1);
            vendingMachine.userChange.setFiveHundred(vendingMachine.machineBalance.getTwoHundred()-1);
        }
        while(bOneh>0 && c>=100){
            c -= 100;
            bOneh--;
            cOneh++;
            vendingMachine.userChange.setOneHundred(vendingMachine.userChange.getOneHundred()+1);
            vendingMachine.userChange.setFiveHundred(vendingMachine.machineBalance.getOneHundred()-1);
        }
        while(bFifty>0 && c>=50){
            c -= 50;
            bFifty--;
            cFifty++;
           vendingMachine.userChange.setFifty(vendingMachine.userChange.getFifty()+1);
            vendingMachine.userChange.setFiveHundred(vendingMachine.machineBalance.getFifty()-1);
        }
        while(bTwenty>0 && c>=20){
            c -= 20;
            bTwenty--;
            cTwenty++;
            vendingMachine.userChange.setTwenty(vendingMachine.userChange.getTwenty()+1);
            vendingMachine.userChange.setFiveHundred(vendingMachine.machineBalance.getTwenty()-1);
        }
        while(bTen>0 && c>=10){
            c -= 10;
            bTen--;
            cTen++;
            vendingMachine.userChange.setTen(vendingMachine.userChange.getTen()+1);
            vendingMachine.userChange.setFiveHundred(vendingMachine.machineBalance.getTen()-1);
        }
        while(bFive>0 && c>=5){
            c -= 5;
            bFive--;
            cFive++;
            vendingMachine.userChange.setFive(vendingMachine.userChange.getFive()+1);
            vendingMachine.userChange.setFiveHundred(vendingMachine.machineBalance.getFive()-1);
        }
        while(bOne>0 && c>=1){
            c-=1;
            bOne--;
            cOne++;
            vendingMachine.userChange.setOne(vendingMachine.userChange.getOne()+1);
            vendingMachine.userChange.setFiveHundred(vendingMachine.machineBalance.getOne()-1);
        }
        String msg = "Five Hundred: "+cFiveh+"\n"+"Two Hundred: "+cTwoh+"\n"+
                    "One Hundred: "+cOneh+"\n"+"Fifty: "+cFifty+"\n"+
                    "Twenty: "+cTwenty+"\n"+"Ten: "+cTen+"\n"+
                    "Five: "+cFive+"\n"+"One: "+cOne+"\n";
        JOptionPane.showMessageDialog(null, msg,
                                "Change", JOptionPane.INFORMATION_MESSAGE);
        vendingMachine.userChange.setOne(0);
        vendingMachine.userChange.setFive(0);
        vendingMachine.userChange.setTen(0);
        vendingMachine.userChange.setTwenty(0);
        vendingMachine.userChange.setFifty(0);
        vendingMachine.userChange.setOneHundred(0);
        vendingMachine.userChange.setTwoHundred(0);
        vendingMachine.userChange.setFiveHundred(0);
    }

    /**
     * When customizing an order, it adds the item to the "cart"
     * @param index
     */
    public void addItemToCart(int index){
        if(vendingMachine.getPayment()>vendingMachine.getInventory().get(index).get(0).getPrice())
        if(vendingMachine.getInventory().get(index).size()>0){
            Item item = vendingMachine.getInventory().get(index).get(0);
            ((SpecialVMModel)vendingMachine).addToCart(item);
            removeItem(index);
        }
    }

    /**
     * Updates the empty labels in the process panels to show
     * the processing of the custom item
     * @param labelList
     */
    public void printProcesses(ArrayList<JLabel> labelList){
        ArrayList<String> processes = ((SpecialVMModel)vendingMachine).getProcesses();
        for(int i = 0; i<processes.size(); i++){
            labelList.get(i).setText(processes.get(i)+" "+vendingMachine.getItemList().get(i));
        }
        frame.revalidate();
        frame.repaint();
    }

    public int getItemPrice(int index){
        return vendingMachine.getInventory().get(index).get(0).getPrice();
    }

    public CustomItem getCustomItem(){
        return ((SpecialVMModel)vendingMachine).getCustomItem();
    }

    public int getDenominationCount(int index){
        switch(index){
            case 8:
                return vendingMachine.getMachineBalance().getOne();
            case 7:
                return vendingMachine.getMachineBalance().getFive();
            case 6:
                return vendingMachine.getMachineBalance().getTen();
            case 5:
                return vendingMachine.getMachineBalance().getTwenty();
            case 4:
                return vendingMachine.getMachineBalance().getFifty();
            case 3:
                return vendingMachine.getMachineBalance().getOneHundred();
            case 2:
                return vendingMachine.getMachineBalance().getTwoHundred();
            case 1:
                return vendingMachine.getMachineBalance().getFiveHundred();
            default:
                return 0;
        }
    }

    public void addDenomination(int denomination){
        int current;
        switch(denomination){
            case 500:
                current = vendingMachine.getMachineBalance().getFiveHundred();
                vendingMachine.getMachineBalance().setFiveHundred(current+1);
                break;
            case 200:
                current = vendingMachine.getMachineBalance().getTwoHundred();
                vendingMachine.getMachineBalance().setTwoHundred(current+1);
                break;
            case 100:
                current = vendingMachine.getMachineBalance().getOneHundred();
                vendingMachine.getMachineBalance().setOneHundred(current+1);
                break;
            case 50:
                current = vendingMachine.getMachineBalance().getFifty();
                vendingMachine.getMachineBalance().setFifty(current+1);
                break;
            case 20:
                current = vendingMachine.getMachineBalance().getTwenty();
                vendingMachine.getMachineBalance().setTwenty(current+1);
                break;
            case 10:
                current = vendingMachine.getMachineBalance().getTen();
                vendingMachine.getMachineBalance().setTen(current+1);
                break;
            case 5:
                current = vendingMachine.getMachineBalance().getFive();
                vendingMachine.getMachineBalance().setFive(current+1);
                break;
            case 1:
                current = vendingMachine.getMachineBalance().getOne();
                vendingMachine.getMachineBalance().setOne(current+1);
                break;
        }
    }

    public void subtractDenomination(int denomination){
        int current;
        switch(denomination){
            case 500:
                current = vendingMachine.getMachineBalance().getFiveHundred();
                vendingMachine.getMachineBalance().setFiveHundred(current-1);
                break;
            case 200:
                current = vendingMachine.getMachineBalance().getTwoHundred();
                vendingMachine.getMachineBalance().setTwoHundred(current-1);
                break;
            case 100:
                current = vendingMachine.getMachineBalance().getOneHundred();
                vendingMachine.getMachineBalance().setOneHundred(current-1);
                break;
            case 50:
                current = vendingMachine.getMachineBalance().getFifty();
                vendingMachine.getMachineBalance().setFifty(current-1);
                break;
            case 20:
                current = vendingMachine.getMachineBalance().getTwenty();
                vendingMachine.getMachineBalance().setTwenty(current-1);
                break;
            case 10:
                current = vendingMachine.getMachineBalance().getTen();
                vendingMachine.getMachineBalance().setTen(current-1);
                break;
            case 5:
                current = vendingMachine.getMachineBalance().getFive();
                vendingMachine.getMachineBalance().setFive(current-1);
                break;
            case 1:
                current = vendingMachine.getMachineBalance().getOne();
                vendingMachine.getMachineBalance().setOne(current-1);
                break;
        }
    }

    public void replenishItem(int index){
        if(vendingMachine.getInventory().get(index).size()<10){
            Item existingItem = vendingMachine.getTemplate(index);
            vendingMachine.getInventory().get(index).add(existingItem);
        }
    }

    public void changeItemPrice(int index){
        String input = JOptionPane.showInputDialog("New Price: ");
        int newPrice = Integer.parseInt(input);
        for(int i = 0; i<vendingMachine.getInventory().get(index).size(); i++){
            vendingMachine.getInventory().get(index).get(i).setPrice(newPrice);
        }
    }

    public void saveItems(){
        Item template;
        for(int i = 0; i<vendingMachine.getInventory().size(); i++){
            template = vendingMachine.getInventory().get(i).get(0);
            vendingMachine.templateHolder.add(template);
        }
    }
}