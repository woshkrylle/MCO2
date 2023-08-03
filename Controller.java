import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Controller {
    private MainMenuView mainMenu;
    private RegularVMView rvmView;
    private SpecialVMView svmView;
    private VMModel vendingMachine;
    private JFrame frame;
    private CardLayout cardLayout;
    private boolean existing = false;

    public Controller(){
        vendingMachine = new VMModel(this);
        this.frame = new JFrame("Vending Machine Factory");
        this.frame.setLayout(new CardLayout());
        this.cardLayout = (CardLayout) frame.getContentPane().getLayout();
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(480, 360);
    }

    public void setMainMenu(MainMenuView mainMenu){
        this.mainMenu = mainMenu;
    }
    public void setRVMView(RegularVMView rvmView){
        this.rvmView = rvmView;
    }
    public void setSVMView(SpecialVMView svmView){
        this.svmView = svmView;
    }

    public void Run(){
        this.frame.setVisible(true);
        cardLayout.show(frame.getContentPane(), "Main Card");
    }

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

    public void testVM(){
        if(existing){
            rvmView.initializeItemButtons();
            svmView.initializeItemButtons();
            cardLayout.show(frame.getContentPane(), "Vending Features Card");
        }else{
            String message = "There is no existing vending machine";
            String title = "Warning!";
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);;
        }
    }

    public JFrame getFrame(){
        return this.frame;
    }

    public CardLayout getCardLayout(){
        return this.cardLayout;
    }

    public boolean checkForItem(String itemName){
        if(vendingMachine.getItemList().contains(itemName)) return true;
        else return false;
    }

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
            boolean independence = vendingMachine.getInventory().get(index).get(0).getIndependence();
            Item existingItem = new Item(name, price, calories, process, independence);
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
     * @param independence
     */
    public void addItemToInventory(int price, int calories, String process, boolean independence){
        String name = vendingMachine.getItemList().get(vendingMachine.getItemList().size()-1);
        Item newItem = new Item (name, price, calories, process, independence);
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

    public int getItemCount(String name){
        int i = vendingMachine.getItemList().indexOf(name);
        return vendingMachine.getInventory().get(i).size();
    }

    public int getItemCount(int index){
        return vendingMachine.getInventory().get(index).size();
    }

    public int getItemIndex(String name){
        return vendingMachine.getItemList().indexOf(name);
    }

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

    public void showItemMenu(){
        if(vendingMachine instanceof SpecialVMModel){
            cardLayout.show(frame.getContentPane(), "Special Items Card");
            svmView.updateLabels();
        }else{
            rvmView.updateLabels();
            cardLayout.show(frame.getContentPane(), "Regular Items Card");
        }
    }

    public String getItemName(int index){
        return vendingMachine.itemList.get(index);
    }

    public void removeItem(int index){
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

    public void replenishChange(){
        vendingMachine.machineBalance.setFiveHundred(100);
        vendingMachine.machineBalance.setTwoHundred(100);
        vendingMachine.machineBalance.setOneHundred(100);
        vendingMachine.machineBalance.setFifty(100);
        vendingMachine.machineBalance.setTwenty(100);
        vendingMachine.machineBalance.setTen(100);
        vendingMachine.machineBalance.setFive(100);
        vendingMachine.machineBalance.setOne(100);
    }

    public int getPaymentTotal(){
        return vendingMachine.getPayment();
    }

    public int getCaloriesTotal(){
        return vendingMachine.getCalories();
    }
    
    public boolean getItemIndependence(int index){
        if(vendingMachine.getInventory().get(index).get(0).getIndependence()) return true;
        else return false;
    }

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
        }
        while(bTwoh>0 && c>=200){
            c -= 200;
            bTwoh--;
            cTwoh++;
            vendingMachine.userChange.setTwoHundred(vendingMachine.userChange.getTwoHundred()+1);
        }
        while(bOneh>0 && c>=100){
            c -= 100;
            bOneh--;
            cOneh++;
            vendingMachine.userChange.setOneHundred(vendingMachine.userChange.getOneHundred()+1);
        }
        while(bFifty>0 && c>=50){
            c -= 50;
            bFifty--;
            cFifty++;
           vendingMachine.userChange.setFifty(vendingMachine.userChange.getFifty()+1);
        }
        while(bTwenty>0 && c>=20){
            c -= 20;
            bTwenty--;
            cTwenty++;
            vendingMachine.userChange.setTwenty(vendingMachine.userChange.getTwenty()+1);
        }
        while(bTen>0 && c>=10){
            c -= 10;
            bTen--;
            cTen++;
            vendingMachine.userChange.setTen(vendingMachine.userChange.getTen()+1);
        }
        while(bFive>0 && c>=5){
            c -= 5;
            bFive--;
            cFive++;
            vendingMachine.userChange.setFive(vendingMachine.userChange.getFive()+1);
        }
        while(bOne>0 && c>=1){
            c-=1;
            bOne--;
            cOne++;
            vendingMachine.userChange.setOne(vendingMachine.userChange.getOne()+1);
        }
        String msg = "Five Hundred: "+cFiveh+"\n"+"Two Hundred: "+cTwoh+"\n"+
                    "One Hundred: "+cOneh+"\n"+"Fifty: "+cFifty+"\n"+
                    "Twenty: "+cTwenty+"\n"+"Ten: "+cTen+"\n"+
                    "Five: "+cFive+"\n"+"One: "+cOne+"\n";
        JOptionPane.showMessageDialog(null, msg,
                                "Change", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addToCart(int index){
        Item item = vendingMachine.getInventory().get(index).get(0);
        if(vendingMachine.getInventory().get(index).size()>0){
            ((SpecialVMModel)vendingMachine).addToCart(item);
            removeItem(index);
        }
    }

    public void printProcesses(ArrayList<JLabel> labelList){
        ArrayList<String> processes = ((SpecialVMModel)vendingMachine).getProcesses();
        for(int i = 0; i<processes.size(); i++){
            labelList.get(i).setText(processes.get(i));
        }
    }

    public CustomItem getCustomItem(){
        return ((SpecialVMModel)vendingMachine).getCustomItem();
    }
}


