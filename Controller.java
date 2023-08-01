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
        this.frame = new JFrame("Tite");
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

    /**
     * Takes the collection of items initialized in the
     * main menu and stores them to the model.
     * @param ArrayList<ArrayList<Items>>
     */
    public void saveInventory(ArrayList<ArrayList<Item>> Inventory){
        
    }

    public JFrame getFrame(){
        return this.frame;
    }

    public CardLayout getCardLayout(){
        return this.cardLayout;
    }
}

