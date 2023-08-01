import java.awt.*;

import javax.swing.*;

public class Controller {
    private MainMenuView mainMenu;
    private RegularVMView rvmView;
    private SpecialVMView svmView;
    private VMModel vmModel;
    private RegularVM vendingMachine;
    private JFrame frame;

    public Controller(){
        this.frame = new JFrame("Tite");
        this.frame.setLayout(new GridLayout(1, 1));
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
        this.frame.setSize(1280, 720);
    }

    public void createSpecial(){
        this.vendingMachine = new SpecialVM(this);
        this.frame.setSize(1280, 720);
        
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

    public JFrame getFrame(){
        return this.frame;
    }

    public void addPanel(JPanel panel){
        this.frame.add(panel);
    }

    public void addItem(int price, int calories, String process){
        
        vendingMachine.addItem();
    }

}

