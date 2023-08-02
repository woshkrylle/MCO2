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

    public int updateTotalPayment(int amount){
        vendingMachine.setPayment(vendingMachine.getPayment()+amount);
        return vendingMachine.getPayment();
    }

    public void showItemMenu(){
        if(vendingMachine instanceof SpecialVMModel){
            //cardLayout.show(frame.getContentPane(), "Special Items Card");
        }else{
            cardLayout.show(frame.getContentPane(), "Regular Items Card");
        }
    }

    public String getItemName(int index){
        return vendingMachine.itemList.get(index);
    }

    public void removeItem(int index){
        vendingMachine.getInventory().get(index).remove(vendingMachine.getInventory().get(index).size()-1);
    }
}

