import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Controller {
    private MainMenuView mainMenu;
    private RegularVMView rvmView;
    private SpecialVMView svmView;
    private VMModel vmModel;
    private RegularVM vendingMachine;
    private JFrame frame;
    private CardLayout cardLayout;

    public Controller(){
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
    public void setVMModel(VMModel vmModel){
        this.vmModel = vmModel;
    }

    public void Run(){
        this.frame.setVisible(true);
    }

    public void createRegular(){
        this.vendingMachine = new RegularVM(this);
    }

    public void createSpecial(){
        this.vendingMachine = new SpecialVM(this);
        
    }

    public boolean testVM(){
        if(vendingMachine != null){
            if(vendingMachine instanceof SpecialVM){
                //open SpecialVMView
                return true;
            }else if(vendingMachine instanceof RegularVM){
                //open RegularVMView
                return true;
            }else{
                return false;
            }
        }else{
            noVM();
            return false;
        }
    }

    public void noVM(){
        String message = "There is no existing vending machine";
        String title = "Warning!";
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }


    public void addPanel(JPanel panel){
        this.frame.add(panel);
    }

    

    public JFrame getFrame(){
        return this.frame;
    }

    public CardLayout getCardLayout(){
        return this.cardLayout;
    }

    public boolean checkForItem(String itemName){
        if(vmModel.getItemList().contains(itemName)) return true;
        else return false;
    }

    public void newItemListEntry(String name){
        vmModel.getItemList().add(name);
    }

    /**
     * This adds an already existing item to the inventory by "Cloning"
     * the first item of that type and adding the clone to the inventory
     * @param name
     */
    public void addItemToInventory(String name){
        int index = vmModel.getItemList().indexOf(name);
        int price = vmModel.getInventory().get(index).get(0).getPrice();
        int calories = vmModel.getInventory().get(index).get(0).getCalories();
        String process = vmModel.getInventory().get(index).get(0).getProcess();
        boolean independence = vmModel.getInventory().get(index).get(0).getIndependence();
        Item existingItem = new Item(name, price, calories, process, independence);
        vmModel.getInventory().get(index).add(existingItem);
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
        String name = vmModel.getItemList().get(vmModel.getItemList().size()-1);
        Item newItem = new Item (name, price, calories, process, independence);
        ArrayList<Item> inventoryRow = new ArrayList<>();
        inventoryRow.add(newItem);
        vmModel.getInventory().add(inventoryRow);
    }


    /**
     * getSlotCount gets the size of the item list as shown in the vending machine model,
     * essentially serving as a getter method for the number of unique items sold in the vending machine
     * @return 
     */
    public int getSlotCount(){
        return vmModel.getItemList().size();
    }

    public int getItemCount(String name){
        int i = vmModel.getItemList().indexOf(name);
        return vmModel.getInventory().get(i).size();
    }

    public int getItemIndex(String name){
        return vmModel.getItemList().indexOf(name);
    }

    public int addMoney(int prevbal, int add){
        
    }

    
}

