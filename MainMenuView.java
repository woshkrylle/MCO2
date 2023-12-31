import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * The View class responsible for the panels showing the main menu,
 * and the menus for the creation of the vending machine
 */
public class MainMenuView {
    private JPanel mainPanel, createPanel, itemPanel;
    private ArrayList<JLabel> itemLabels = new ArrayList<>();
    private Controller controller;

    /**
     * Creates a MainMenuView Object, which consists of three panels that
     * will be shown for (a) The Main Menu,
     * (b) Adding Items, (c) Creating New Items.
     * @param controller is the controller used for handling processess throughout VMC
     */
    public MainMenuView(Controller controller){
        this.controller = controller;

        this.mainPanel = InitializeMainPanel();
        this.createPanel = InitializeCreatePanel();
        this.itemPanel = InitializeItemPanel();

        controller.getFrame().add(mainPanel, "Main Card");
        controller.getFrame().add(createPanel, "Create Card");
        controller.getFrame().add(itemPanel, "Item Card");
    }

    /**
     * Initializes the GUI for the Main Menu, which is a grid panel of 3 rows and 1 column, each panel has 
     * buttons that each does a different action, one for Creating a Vending machine (createVM), one for
     * testing (testVM), and another one to exit the interface.
     */
    private JPanel InitializeMainPanel(){
        JPanel panel = new JPanel(new GridLayout(3, 1));

        //Button for "Create Vending Machine"
        JButton createButton = new JButton("Create a New Vending Machine");
        createButton.setFocusable(false);

        /*
         * Calls the createVM method in the controller class when pressed
         * which in turn creates a new VMModel(or SpecialVMModel) Object
         * and shifts you to the Add Item Panel
         */
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Object[] options = {"Regular", "Special"};
                int choice = JOptionPane.showOptionDialog(createButton, 
                                                  "Regular or Special?", 
                                                          "Create New Vending Machine", 
                                                          JOptionPane.YES_NO_CANCEL_OPTION, 
                                                          JOptionPane.QUESTION_MESSAGE, 
                                                          null, options, options[0]);
                controller.createVM(choice);
            }
        });

        //Button for "Test Vending Machine
        JButton testButton = new JButton("Test Existing Vending Machine");
        testButton.setFocusable(false);

        /*
         * Shifts you to the panel that asks your input
         * of moneyzzz
         */
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.testVM();
            }
        });
        
        //Button for exit; terminates the program
        JButton exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        panel.add(createButton);
        panel.add(testButton);
        panel.add(exitButton);
        panel.setVisible(true);
        return panel;
    }

    /**
     * Initializes GUI that will show when creating a new
     * vending machine. This panel has 2 rows, and the row above asks for the name, while the row below
     * displays the list of items that were successfully made along with the item stocks
     * 
     */
    private JPanel InitializeCreatePanel(){
        JPanel panel = new JPanel(new GridLayout(2,1));


        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
        JPanel itemPanel = new JPanel(new FlowLayout());

        JTextField itemName = new JTextField("Name");
        itemName.setColumns(15);
        
        JLabel lbl = new JLabel();
        lbl.setText("Slots Filled: "+ controller.getSlotCount());
        
        JButton submitButton = new JButton("Add Item");
        submitButton.setFocusable(false);
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = itemName.getText();
                
                if(!controller.checkForItem(name)){
                    if(controller.newItemListEntry(name)){
                        controller.getCardLayout().show(controller.getFrame().getContentPane(), "Item Card");
                        lbl.setText("Slots Filled: " + controller.getSlotCount());
                        addItemCounter(name, inventoryPanel);
                        inventoryPanel.revalidate();
                        inventoryPanel.repaint();
                    }
                }else{
                    if(controller.addItemToInventory(name)){
                        updateItemCounter(name);
                        inventoryPanel.revalidate();
                        inventoryPanel.repaint();
                    }
                }
            }
        });
        
        JButton proceedButton = new JButton("Proceed");
        proceedButton.setFocusable(false);
        proceedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.saveItems();
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });
        
        inventoryPanel.add(lbl);
        itemPanel.add(itemName);
        itemPanel.add(submitButton);
        itemPanel.add(proceedButton);

        panel.add(itemPanel);
        panel.add(inventoryPanel);
        panel.setVisible(true);
        return panel;
    }

    /**
     * Initializes the GUI that will show when adding a
     * new unique item, makes the user input the Price, Calories, Process, and if it can go]
     * Solo
     */
    private JPanel InitializeItemPanel(){
        JPanel panel = new JPanel(new GridLayout(4,1));

        JPanel pricePanel = new JPanel(new BorderLayout());
        JLabel priceLabel = new JLabel("Price:");
        pricePanel.add(priceLabel, BorderLayout.WEST);
        JTextField priceTextField = new JTextField();
        priceTextField.setColumns(15);
        pricePanel.add(priceTextField, BorderLayout.EAST);
        
        
        JPanel caloriePanel = new JPanel(new BorderLayout());
        JLabel calorieLabel = new JLabel("Calories:");
        caloriePanel.add(calorieLabel, BorderLayout.WEST);
        JTextField calorieTextField = new JTextField();
        calorieTextField.setColumns(15);
        caloriePanel.add(calorieTextField, BorderLayout.EAST);

        JPanel processPanel = new JPanel(new BorderLayout());
        JLabel processLabel = new JLabel("Process:");
        processPanel.add(processLabel, BorderLayout.WEST);
        JTextField processTextField = new JTextField();
        processTextField.setColumns(15);
        processPanel.add(processTextField, BorderLayout.EAST);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int price = Integer.parseInt(priceTextField.getText());
                int calories = Integer.parseInt(calorieTextField.getText());
                String process = processTextField.getText();
                controller.addItemToInventory(price, calories, process);
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Create Card");
            }
        });

        panel.add(pricePanel);
        panel.add(caloriePanel);
        panel.add(processPanel);
        panel.add(submitButton);
        panel.setVisible(true);
        return panel;
    }

    /**
     * Adds a label to the Create Vending Machine GUI
     * when a new unique item is added
     * @param name name of the item already created
     * @param panel JPanel of the create menu where this is added
     */
    public void addItemCounter(String name, JPanel panel){
        JLabel newLabel = new JLabel();
        newLabel.setText(name+": 1");
        panel.add(newLabel);
        itemLabels.add(newLabel);
    }

    /**
     * Updates the state of the labels that shows
     * which items you have and how many of them
     * there are
     * @param name name of the item, used for checking
     */
    public void updateItemCounter(String name){
        int index = controller.getItemIndex(name);
        JLabel label = itemLabels.get(index);
        label.setText(name+": "+controller.getItemCount(name));
    }

    
}
